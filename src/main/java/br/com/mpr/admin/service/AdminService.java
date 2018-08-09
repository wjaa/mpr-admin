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

    public Serializable getCupom(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                CupomVo.class,properties.getWsApi(), "api/v1/admin/" + CUPOM_ENTITY, id.toString());
    }

    public Serializable getEstoqueById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                EstoqueVo.class,properties.getWsApi(), "api/v1/admin/" + ESTOQUE_ENTITY, id.toString());
    }

    public Serializable getTabelaPrecoById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                TabelaPrecoVo.class,properties.getWsApi(), "api/v1/admin/" + TABELA_PRECO_ENTITY, id.toString());
    }

    public Serializable getProdutoById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                ProdutoVo.class,properties.getWsApi(), "api/v1/admin/" + PRODUTO_ENTITY, id.toString());
    }

    public Serializable getTipoProdutoById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                TipoProdutoVo.class,properties.getWsApi(), "api/v1/admin/" + TIPO_PRODUTO_ENTITY, id.toString());
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
            default: throw new RestException(500,"Argumento [entity] inválido!");

        }
    }

    public List<FornecedorVo> listAllFornecedor() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        FornecedorVo[].class,properties.getWsApi(), "api/v1/admin/" + FORNECEDOR_ENTITY + "/all"));
    }

    public List<? extends Serializable> listAllCliente() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        ClienteVo[].class,properties.getWsApi(), "api/v1/admin/" + CLIENTE_ENTITY + "/all"));
    }

    public List<? extends Serializable> listaAllCupom() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        CupomVo[].class,properties.getWsApi(), "api/v1/admin/" + CUPOM_ENTITY + "/all"));
    }

    public List<? extends Serializable> listAllEstoque() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        EstoqueVo[].class,properties.getWsApi(), "api/v1/admin/" + ESTOQUE_ENTITY + "/all"));
    }

    public List<? extends Serializable> listAllTabelaPreco() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        TabelaPrecoVo[].class,properties.getWsApi(), "api/v1/admin/" + TABELA_PRECO_ENTITY + "/all"));
    }

    public List<? extends Serializable> listAllProduto() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        ProdutoVo[].class,properties.getWsApi(), "api/v1/admin/" + PRODUTO_ENTITY + "/all"));
    }

    public List<? extends Serializable> listAllTipoProduto() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        TipoProdutoVo[].class,properties.getWsApi(), "api/v1/admin/" + TIPO_PRODUTO_ENTITY + "/all"));
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
            default: throw new RestException(500,"Argumento [entity] {" +
                    "inválido!");

        }
    }

    public FornecedorVo saveFornecedor(FornecedorVo fornecedorVo) throws RestException {
        return RestUtils.postJson(FornecedorVo.class,
                properties.getWsApi(), "api/v1/admin/" + FORNECEDOR_ENTITY + "/save",
                ObjectUtils.toJson(fornecedorVo));

    }

    public Serializable saveCliente(ClienteVo clienteVo) throws RestException {
        return RestUtils.postJson(ClienteVo.class,
                properties.getWsApi(), "api/v1/admin/" + CLIENTE_ENTITY + "/save",
                ObjectUtils.toJson(clienteVo));
    }

    public Serializable saveCupom(CupomVo cupomVo) throws RestException {
        return RestUtils.postJson(CupomVo.class,
                properties.getWsApi(), "api/v1/admin/" + CUPOM_ENTITY + "/save",
                ObjectUtils.toJson(cupomVo));
    }

    public Serializable saveEstoque(EstoqueVo estoqueVo) throws RestException {
        return RestUtils.postJson(EstoqueVo.class,
                properties.getWsApi(), "api/v1/admin/" + ESTOQUE_ENTITY + "/save",
                ObjectUtils.toJson(estoqueVo));
    }

    public Serializable saveTabelaPreco(TabelaPrecoVo tabelaPrecoVo) throws RestException {
        return RestUtils.postJson(TabelaPrecoVo.class,
                properties.getWsApi(), "api/v1/admin/" + TABELA_PRECO_ENTITY + "/save",
                ObjectUtils.toJson(tabelaPrecoVo));
    }

    public Serializable saveProduto(ProdutoVo produtoVo) throws RestException {
        return RestUtils.postJson(ProdutoVo.class,
                properties.getWsApi(), "api/v1/admin/" + PRODUTO_ENTITY + "/save",
                ObjectUtils.toJson(produtoVo));
    }

    public Serializable saveTipoProduto(TipoProdutoVo tipoProdutoVo) throws RestException {
        return RestUtils.postJson(TipoProdutoVo.class,
                properties.getWsApi(), "api/v1/admin/" + TIPO_PRODUTO_ENTITY + "/save",
                ObjectUtils.toJson(tipoProdutoVo));
    }

}
