package br.com.mpr.admin.controllers;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.service.AdminService;
import br.com.mpr.admin.utils.BeanUtils;
import br.com.mpr.admin.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {


    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String SUCCESS_MESSAGE = "successMessage";
    @Autowired
    private AdminService adminService;

    private Map<String,String> mapEntity = new HashMap<>();

    @PostConstruct
    private void init(){
        mapEntity.put("FornecedorEntity.list","fornecedor/list");
        mapEntity.put("FornecedorEntity.view","fornecedor/view");
        mapEntity.put("TipoProdutoEntity.list","tipoProduto/list");
        mapEntity.put("TipoProdutoEntity.view","tipoProduto/view");
        mapEntity.put("ProdutoEntity.list","produto/list");
        mapEntity.put("ProdutoEntity.view","produto/view");
        mapEntity.put("EstoqueEntity.list","estoque/list");
        mapEntity.put("EstoqueEntity.view","estoque/view");
        mapEntity.put("EstoqueEntity.byIdProduto","estoque/listLote");
        mapEntity.put("CupomEntity.list","cupom/list");
        mapEntity.put("CupomEntity.view","cupom/view");
        mapEntity.put("TabelaPrecoEntity.list","tabelaPreco/list");
        mapEntity.put("TabelaPrecoEntity.view","tabelaPreco/view");
        mapEntity.put("ClienteEntity.list","cliente/list");
        mapEntity.put("ClienteEntity.view","cliente/view");
        mapEntity.put("PedidoEntity.list","pedido/list");
        mapEntity.put("PedidoEntity.view","pedido/view");
        mapEntity.put("CatalogoGrupoEntity.list","catalogoGrupo/list");
        mapEntity.put("CatalogoGrupoEntity.view","catalogoGrupo/view");
        mapEntity.put("CatalogoEntity.list","catalogo/list");
        mapEntity.put("CatalogoEntity.view","catalogo/view");

    }


    @GetMapping("/{entity}")
    public ModelAndView listEntity(@PathVariable String entity){
        ModelAndView mav = new ModelAndView(mapEntity.get(entity + ".list"));
        try {
            mav.addObject("list",adminService.listAllEntity(entity));
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }


    @GetMapping("/EstoqueEntity/byIdProduto/{idProduto}")
    public ModelAndView listByIdProduto(@PathVariable Long idProduto){
        ModelAndView mav = new ModelAndView(mapEntity.get("EstoqueEntity.byIdProduto"));
        try {
            mav.addObject("list",adminService.listEstoqueByIdProduto(idProduto));
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }



    @GetMapping("/{entity}/{id}")
    public ModelAndView getEntity(@PathVariable String entity, @PathVariable Long id,
                                  @RequestParam(required = false) Boolean readOnly,
                                  @ModelAttribute("vo") Object flashVo){
        ModelAndView mav = new ModelAndView(mapEntity.get(entity + ".view"));
        try {

            Serializable vo = adminService.getEntityById(entity,id);
            //so adiciona o objeto se nao for nulo por causa do redirect do save.
            if ( vo != null && id != null) {
                //adicionando tudo que foi preenchido no form antes do erro.
                if (flashVo != null){
                    BeanUtils.copyPropertiesIgnoreAnnotation(flashVo,vo);
                }

                mav.addObject("vo",vo);
            }
            mav.addObject("readOnly", readOnly);
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @DeleteMapping("/{entity}/{id}")
    public ResponseEntity<String> removeEntity(@PathVariable String entity, @PathVariable Long id){
        try {

            adminService.removeEntityById(entity,id);
            return new ResponseEntity(HttpStatus.OK);

        } catch (RestException e) {
            return new ResponseEntity(e.getErrorMessageVo().getFullError(),
                    HttpStatus.valueOf(e.getErrorMessageVo().getErrorCode() == null ?
                            HttpStatus.INTERNAL_SERVER_ERROR.value() : e.getErrorMessageVo().getErrorCode()));
        }

    }

    @PostMapping("/FornecedorEntity/save")
    public String saveEntity(@ModelAttribute FornecedorVo fornecedorVo,
                             final RedirectAttributes redirectAttributes){
        try {
            fornecedorVo = adminService.saveFornecedor(fornecedorVo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Fornecedor cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",fornecedorVo);
        }
        String redirect = "redirect:/admin/FornecedorEntity/" + (fornecedorVo.getId() == null ? "0"
                : String.valueOf(fornecedorVo.getId()));
        return redirect;
    }

    @PostMapping("/TipoProdutoEntity/save")
    public String saveEntity(@ModelAttribute TipoProdutoVo tipoProdutoVo,
                             final RedirectAttributes redirectAttributes){
        try {
            tipoProdutoVo = adminService.saveTipoProduto(tipoProdutoVo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Tipo de produto cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",tipoProdutoVo);
        }
        String redirect = "redirect:/admin/TipoProdutoEntity/" + (tipoProdutoVo.getId() == null ? "0"
                : String.valueOf(tipoProdutoVo.getId()));
        return redirect;
    }


    @PostMapping("/ProdutoEntity/save")
    public String saveEntity(@ModelAttribute ProdutoVo produtoVo,
                             final RedirectAttributes redirectAttributes){
        try {
            if (produtoVo.getDestaque() != null && !produtoVo.getDestaque().isEmpty()){
                produtoVo.setByteImgDestaque(produtoVo.getDestaque().getBytes());
                produtoVo.setNameImgDestaque(produtoVo.getDestaque().getOriginalFilename());
            }
            if (produtoVo.getPreview() != null && !produtoVo.getPreview().isEmpty()){
                produtoVo.setByteImgPreview(produtoVo.getPreview().getBytes());
                produtoVo.setNameImgPreview(produtoVo.getPreview().getOriginalFilename());
            }
            if (produtoVo.getListDestaque() != null && produtoVo.getListDestaque().length > 0){
                if (produtoVo.getListImgDestaque() == null) {
                    produtoVo.setListImgDestaque(new ArrayList<>());
                }
                for (MultipartFile file : produtoVo.getListDestaque()){
                    if (!file.isEmpty()){
                        ProdutoImagemDestaqueVo destaqueVo = new ProdutoImagemDestaqueVo();
                        destaqueVo.setByteImgDestaque(file.getBytes());
                        destaqueVo.setNameImgDestaque(file.getOriginalFilename());
                        produtoVo.getListImgDestaque().add(destaqueVo);
                    }
                }
            }
            produtoVo = adminService.saveProduto(produtoVo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Produto cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",produtoVo);
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,
                    new ErrorMessageVo(500,"Erro ao ler uma imagem do produto"));
            redirectAttributes.addFlashAttribute("vo",produtoVo);
        }
        String redirect = "redirect:/admin/ProdutoEntity/" + (produtoVo.getId() == null ? "0"
                : String.valueOf(produtoVo.getId()));
        return redirect;
    }


    @PostMapping("/EstoqueEntity/save")
    public String saveEntity(@ModelAttribute EstoqueVo estoque,
                             final RedirectAttributes redirectAttributes){
        try {
            estoque = adminService.saveEstoque(estoque);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Estoque cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",estoque);
        }
        String redirect = "redirect:/admin/EstoqueEntity/" + (estoque.getId() == null ? "0"
                : String.valueOf(estoque.getId()));
        return redirect;
    }

    @PostMapping("/CupomEntity/save")
    public String saveEntity(@ModelAttribute CupomVo cupom,
                             final RedirectAttributes redirectAttributes){
        try {
            cupom = adminService.saveCupom(cupom);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Cupom cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",cupom);
        }
        String redirect = "redirect:/admin/CupomEntity/" + (cupom.getId() == null ? "0"
                : String.valueOf(cupom.getId()));
        return redirect;
    }


    @PostMapping("/TabelaPrecoEntity/save")
    public String saveEntity(@ModelAttribute TabelaPrecoVo tabelaPreco,
                             final RedirectAttributes redirectAttributes){
        try {
            tabelaPreco = adminService.saveTabelaPreco(tabelaPreco);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Tabela Preco cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",tabelaPreco);
        }
        String redirect = "redirect:/admin/TabelaPrecoEntity/" + (tabelaPreco.getId() == null ? "0"
                : String.valueOf(tabelaPreco.getId()));
        return redirect;
    }

    @PostMapping("/CatalogoGrupoEntity/save")
    public String saveCatalogoGrupoEntity(@ModelAttribute CatalogoGrupoVo catalogoGrupo,
                             final RedirectAttributes redirectAttributes){
        try {
            catalogoGrupo = adminService.saveCatalogoGrupo(catalogoGrupo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Catalogo cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",catalogoGrupo);
        }
        String redirect = "redirect:/admin/CatalogoGrupoEntity/" + (catalogoGrupo.getId() == null ? "0"
                : String.valueOf(catalogoGrupo.getId()));
        return redirect;
    }

    @PostMapping("/CatalogoEntity/save")
    public String saveImagemExclusiva(@ModelAttribute CatalogoVo catalogo,
                             final RedirectAttributes redirectAttributes){
        try {
            if (catalogo.getFileImg() != null && !catalogo.getFileImg().isEmpty()){
                catalogo.setByteImg(catalogo.getFileImg().getBytes());
                catalogo.setNameImg(catalogo.getFileImg().getOriginalFilename());
            }
            catalogo = adminService.saveCatalogo(catalogo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Imagem exclusiva cadastrada com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",catalogo);
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,
                    new ErrorMessageVo(500,"Erro ao ler a imagem do upload."));
            redirectAttributes.addFlashAttribute("vo",catalogo);
        }
        String redirect = "redirect:/admin/CatalogoEntity/" + (catalogo.getId() == null ? "0"
                : String.valueOf(catalogo.getId()));
        return redirect;
    }

    @PostMapping("/ClienteEntity/save")
    public String saveEntity(@ModelAttribute ClienteVo clienteVo,
                             final RedirectAttributes redirectAttributes){
        try {
            clienteVo = adminService.saveCliente(clienteVo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Cliente cadastrado com sucesso!");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
            redirectAttributes.addFlashAttribute("vo",clienteVo);
        }
        String redirect = "redirect:/admin/ClienteEntity/" + (clienteVo.getId() == null ? "0"
                : String.valueOf(clienteVo.getId()));
        return redirect;
    }

    @GetMapping("/PedidoEntity/list")
    public ModelAndView listPedido(){
        ModelAndView mav = new ModelAndView(mapEntity.get("PedidoEntity.list"));
        try{
            mav.addObject("listSysCode", this.adminService.listAllSysCode());
        }catch(RestException e){
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @PostMapping("/PedidoEntity/find")
    public ModelAndView findPedido(@ModelAttribute PedidoFindForm pedidoFindForm){
        ModelAndView mav = new ModelAndView(mapEntity.get("PedidoEntity.list"));
        try {
            mav.addObject("listSysCode", this.adminService.listAllSysCode());
            mav.addObject("list", adminService.findPedido(pedidoFindForm));
        }catch (RestException e){
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @GetMapping("/ProdutoEntity/list")
    public ModelAndView listProdutos(){
        ModelAndView mav = new ModelAndView(mapEntity.get("ProdutoEntity.list"));
        try{
            mav.addObject("listTipoProduto", this.adminService.listAllTipoProduto());
            mav.addObject("list", adminService.listAllProduto());
        }catch(RestException e){
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @PostMapping("/ProdutoEntity/find")
    public ModelAndView findProduto(@ModelAttribute ProdutoFindForm produtoFindForm){
        ModelAndView mav = new ModelAndView(mapEntity.get("ProdutoEntity.list"));
        try {
            mav.addObject("listTipoProduto", this.adminService.listAllTipoProduto());
            mav.addObject("list", adminService.findProduto(produtoFindForm));
        }catch (RestException e){
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }
}
