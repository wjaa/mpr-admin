package br.com.mpr.admin.service;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.properties.MprAdminProperties;
import br.com.mpr.admin.utils.ObjectUtils;
import br.com.mpr.admin.utils.RestUtils;
import br.com.mpr.admin.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wagner on 7/21/18.
 */
@Service
public class AdminService {

    public static final String FORNECEDOR_ENTITY = "FornecedorEntity";
    public static final String CLIENTE_ENTITY = "ClienteEntity";
    public static final String CUPOM_ENTITY = "CupomEntity";
    public static final String ESTOQUE_ENTITY = "EstoqueEntity";
    public static final String TABELA_PRECO_ENTITY = "TabelaPrecoEntity";
    public static final String PRODUTO_ENTITY = "ProdutoEntity";
    public static final String TIPO_PRODUTO_ENTITY = "TipoProdutoEntity";
    public static final String CATALOGO_GRUPO_ENTITY = "CatalogoGrupoEntity";
    public static final String CATALOGO_ENTITY = "CatalogoEntity";


    @Autowired
    private MprAdminProperties properties;


    public Serializable getEntityById(String entity, Long id) throws RestException {

        switch (entity) {
            case FORNECEDOR_ENTITY: return getFornecedorById(id);
            case TIPO_PRODUTO_ENTITY: return getTipoProdutoById(id);
            case PRODUTO_ENTITY: return getProdutoById(id);
            case TABELA_PRECO_ENTITY: return getTabelaPrecoById(id);
            case ESTOQUE_ENTITY: return getEstoqueById(id);
            case CUPOM_ENTITY: return getCupom(id);
            case CLIENTE_ENTITY: return getClienteById(id);
            case CATALOGO_GRUPO_ENTITY: return getCatalogoGrupoById(id);
            case CATALOGO_ENTITY: return getCatalogoById(id);
            default: throw new RestException(500, "Argumento [entity] inválido!");

        }
    }

    public FornecedorVo getFornecedorById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                FornecedorVo.class,properties.getWsApi(), "api/v1/admin/" + FORNECEDOR_ENTITY, id.toString());
    }

    public ClienteVo getClienteById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                ClienteVo.class,properties.getWsApi(), "api/v1/admin/" + CLIENTE_ENTITY, id.toString());
    }

    public CupomVo getCupom(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                CupomVo.class,properties.getWsApi(), "api/v1/admin/" + CUPOM_ENTITY, id.toString());
    }

    public EstoqueVo getEstoqueById(Long id) throws RestException {
        EstoqueVo vo = RestUtils.getJsonWithParamPath(
                EstoqueVo.class,properties.getWsApi(), "api/v1/admin/" + ESTOQUE_ENTITY, id.toString());
        if (vo == null){
            vo = new EstoqueVo();
        }
        vo.setProdutos(this.listAllProduto());
        vo.setFornecedores(this.listAllFornecedor());
        return vo;
    }

    public TabelaPrecoVo getTabelaPrecoById(Long id) throws RestException {
        TabelaPrecoVo vo = RestUtils.getJsonWithParamPath(
                TabelaPrecoVo.class,properties.getWsApi(), "api/v1/admin/" + TABELA_PRECO_ENTITY, id.toString());

        if (vo == null){
            vo = new TabelaPrecoVo();
        }
        vo.setProdutos(this.listAllProduto());

        return vo;
    }

    public ProdutoVo getProdutoById(Long id) throws RestException {
        ProdutoVo produtoVo = RestUtils.getJsonWithParamPath(
                ProdutoVo.class,properties.getWsApi(), "api/v1/admin/" + PRODUTO_ENTITY, id.toString());
        if (produtoVo == null){
            produtoVo = new ProdutoVo();
        }
        produtoVo.setListTipoProdutos(this.listAllTipoProduto());
        return produtoVo;
    }

    public TipoProdutoVo getTipoProdutoById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                TipoProdutoVo.class,properties.getWsApi(), "api/v1/admin/" + TIPO_PRODUTO_ENTITY, id.toString());
    }

    public CatalogoGrupoVo getCatalogoGrupoById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                CatalogoGrupoVo.class,properties.getWsApi(), "api/v1/admin/" + CATALOGO_GRUPO_ENTITY, id.toString());
    }

    public CatalogoVo getCatalogoById(Long id) throws RestException {
        CatalogoVo vo = RestUtils.getJsonWithParamPath(
                CatalogoVo.class,properties.getWsApi(), "api/v1/admin/" + CATALOGO_ENTITY, id.toString());
        if (vo == null){
            vo = new CatalogoVo();
            vo.setAtivo(true);
        }
        vo.setListCatalogoGrupo(this.listAllCatalogoGrupo());
        return vo;
    }


    public List<? extends Serializable> listAllEntity(String entity) throws RestException {
        switch (entity) {
            case FORNECEDOR_ENTITY: return listAllFornecedor();
            case TIPO_PRODUTO_ENTITY: return listAllTipoProduto();
            case PRODUTO_ENTITY: return listAllProduto();
            case TABELA_PRECO_ENTITY: return listAllTabelaPreco();
            case ESTOQUE_ENTITY: return listAllEstoque();
            case CUPOM_ENTITY: return listaAllCupom();
            case CLIENTE_ENTITY: return listAllCliente();
            case CATALOGO_GRUPO_ENTITY: return listAllCatalogoGrupo();
            case CATALOGO_ENTITY: return listAllCatalogo();
            default: throw new RestException(500,"Argumento [entity] inválido!");

        }
    }

    public List<FornecedorVo> listAllFornecedor() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        FornecedorVo[].class,properties.getWsApi(), "api/v1/admin/" + FORNECEDOR_ENTITY + "/all"));
    }

    public List<ClienteVo> listAllCliente() throws RestException {
        List<ClienteVo> list = Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        ClienteVo[].class,properties.getWsApi(), "api/v1/admin/" + CLIENTE_ENTITY + "/all"));

        return list;
    }

    public List<CupomVo> listaAllCupom() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        CupomVo[].class,properties.getWsApi(), "api/v1/admin/" + CUPOM_ENTITY + "/all"));
    }

    public List<ProdutoEstoqueVo> listAllEstoque() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        ProdutoEstoqueVo[].class,properties.getWsApi(), "api/v1/admin/" + ESTOQUE_ENTITY + "/all"));
    }

    public List<TabelaPrecoVo> listAllTabelaPreco() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        TabelaPrecoVo[].class,properties.getWsApi(), "api/v1/admin/" + TABELA_PRECO_ENTITY + "/all"));
    }

    public List<ProdutoVo> listAllProduto() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        ProdutoVo[].class,properties.getWsApi(), "api/v1/admin/" + PRODUTO_ENTITY + "/all"));
    }

    public List<TipoProdutoVo> listAllTipoProduto() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        TipoProdutoVo[].class,properties.getWsApi(), "api/v1/admin/" + TIPO_PRODUTO_ENTITY + "/all"));
    }

    public List<CatalogoGrupoVo> listAllCatalogoGrupo() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        CatalogoGrupoVo[].class,properties.getWsApi(), "api/v1/admin/" + CATALOGO_GRUPO_ENTITY + "/all"));
    }

    public List<CatalogoVo> listAllCatalogo() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        CatalogoVo[].class,properties.getWsApi(), "api/v1/admin/" + CATALOGO_ENTITY + "/all"));
    }



    public Serializable saveEntity(String entity, String jsonEntity) throws RestException {

        switch (entity) {
            case FORNECEDOR_ENTITY: return saveFornecedor(ObjectUtils.fromJSON(jsonEntity, FornecedorVo.class));
            case TIPO_PRODUTO_ENTITY: return saveTipoProduto(ObjectUtils.fromJSON(jsonEntity, TipoProdutoVo.class));
            case PRODUTO_ENTITY: return saveProduto(ObjectUtils.fromJSON(jsonEntity, ProdutoVo.class));
            case TABELA_PRECO_ENTITY: return saveTabelaPreco(ObjectUtils.fromJSON(jsonEntity, TabelaPrecoVo.class));
            case ESTOQUE_ENTITY: return saveEstoque(ObjectUtils.fromJSON(jsonEntity, EstoqueVo.class));
            case CUPOM_ENTITY: return saveCupom(ObjectUtils.fromJSON(jsonEntity, CupomVo.class));
            case CLIENTE_ENTITY: return saveCliente(ObjectUtils.fromJSON(jsonEntity, ClienteVo.class));
            case CATALOGO_GRUPO_ENTITY: return saveCatalogoGrupo(ObjectUtils.fromJSON(jsonEntity, CatalogoGrupoVo.class));
            case CATALOGO_ENTITY: return saveCatalogo(ObjectUtils.fromJSON(jsonEntity, CatalogoVo.class));
            default: throw new RestException(500,"Argumento [entity] {" +
                    "inválido!");

        }
    }

    public FornecedorVo saveFornecedor(FornecedorVo fornecedorVo) throws RestException {
        return RestUtils.postJson(FornecedorVo.class,
                properties.getWsApi(), "api/v1/admin/" + FORNECEDOR_ENTITY + "/save",
                ObjectUtils.toJson(fornecedorVo));

    }

    public ClienteVo saveCliente(ClienteVo clienteVo) throws RestException {
        return RestUtils.postJson(ClienteVo.class,
                properties.getWsApi(), "api/v1/admin/" + CLIENTE_ENTITY + "/save",
                ObjectUtils.toJson(clienteVo));
    }

    public CupomVo saveCupom(CupomVo cupomVo) throws RestException {
        return RestUtils.postJson(CupomVo.class,
                properties.getWsApi(), "api/v1/admin/" + CUPOM_ENTITY + "/save",
                ObjectUtils.toJson(cupomVo));
    }

    public EstoqueVo saveEstoque(EstoqueVo estoqueVo) throws RestException {
        return RestUtils.postJson(EstoqueVo.class,
                properties.getWsApi(), "api/v1/admin/" + ESTOQUE_ENTITY + "/save",
                ObjectUtils.toJson(estoqueVo));
    }

    public TabelaPrecoVo saveTabelaPreco(TabelaPrecoVo tabelaPrecoVo) throws RestException {
        return RestUtils.postJson(TabelaPrecoVo.class,
                properties.getWsApi(), "api/v1/admin/" + TABELA_PRECO_ENTITY + "/save",
                ObjectUtils.toJson(tabelaPrecoVo));
    }

    public ProdutoVo saveProduto(ProdutoVo produtoVo) throws RestException {
        return RestUtils.postJson(ProdutoVo.class,
                properties.getWsApi(), "api/v1/admin/" + PRODUTO_ENTITY + "/save",
                ObjectUtils.toJson(produtoVo));
    }

    public TipoProdutoVo saveTipoProduto(TipoProdutoVo tipoProdutoVo) throws RestException {
        return RestUtils.postJson(TipoProdutoVo.class,
                properties.getWsApi(), "api/v1/admin/" + TIPO_PRODUTO_ENTITY + "/save",
                ObjectUtils.toJson(tipoProdutoVo));
    }

    public CatalogoGrupoVo saveCatalogoGrupo(CatalogoGrupoVo catalogoGrupo) throws RestException {
        return RestUtils.postJson(CatalogoGrupoVo.class,
                properties.getWsApi(), "api/v1/admin/" + CATALOGO_GRUPO_ENTITY + "/save",
                ObjectUtils.toJson(catalogoGrupo));
    }

    public CatalogoVo saveCatalogo(CatalogoVo catalogo) throws RestException {
        return RestUtils.postJson(CatalogoVo.class,
                properties.getWsApi(), "api/v1/admin/" + CATALOGO_ENTITY + "/save",
                ObjectUtils.toJson(catalogo));
    }

    public List<EstoqueVo> listEstoqueByIdProduto(Long idProduto) throws RestException  {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        EstoqueVo[].class,properties.getWsApi(), "api/v1/admin/" +
                                ESTOQUE_ENTITY + "/byIdProduto/" + idProduto));
    }

    public List<SysCodeVo> listAllSysCode() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        SysCodeVo[].class,properties.getWsApi(), "api/v1/admin/SysCode/list"));
    }

    public List<PedidoVo> findPedido(PedidoFindForm pedidoFindForm) throws RestException {
        if ("".equals(pedidoFindForm.getSysCode())){
            pedidoFindForm.setSysCode(null);
        }
        return Arrays.asList(
                RestUtils.postJson(PedidoVo[].class,
                properties.getWsApi(), "api/v1/admin/PedidoEntity/find",
                ObjectUtils.toJson(pedidoFindForm)));
    }

    public List<ProdutoVo> findProduto(ProdutoFindForm produtoFindForm) throws RestException {
        return Arrays.asList(
                RestUtils.postJson(ProdutoVo[].class,
                        properties.getWsApi(), "api/v1/admin/ProdutoEntity/find",
                        ObjectUtils.toJson(produtoFindForm)));
    }


    public void removeEntityById(String entity, Long id) throws RestException {
        switch (entity) {
            case CATALOGO_ENTITY:
                removeCatalogoById(id);
                break;
        }

    }

    private void removeCatalogoById(Long id) throws RestException {
        RestUtils.delete(properties.getWsApi() , "api/v1/admin" , CATALOGO_ENTITY, id.toString());
    }
}
