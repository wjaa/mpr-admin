package br.com.mpr.admin.service;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.properties.MprAdminProperties;
import br.com.mpr.admin.utils.ObjectUtils;
import br.com.mpr.admin.utils.RestUtilsApp;
import br.com.mpr.admin.utils.RestUtilsAuth;
import br.com.mpr.admin.utils.Token;
import br.com.mpr.admin.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Service
public class CheckoutService {

    @Autowired
    private MprAdminProperties properties;

    public String getCheckoutToken() throws RestException {
        return RestUtilsApp.get(properties.getWsApi(), "api/v1/core/checkout/token");
    }

    public CarrinhoVo addItemCarrinho(Token token, ItemCarrinhoForm item) throws RestException {
        return RestUtilsAuth.putJson(token,CarrinhoVo.class,
                properties.getWsApi(), "api/v1/core/carrinho/add",
                ObjectUtils.toJson(item));
    }

    public CheckoutVo checkout(Long idCarrinho) throws RestException {
        return RestUtilsApp.getJsonWithParamPath(
                CheckoutVo.class,properties.getWsApi(), "api/v1/core/checkout", idCarrinho.toString());
    }

    public CarrinhoVo getCarrinho(Token token) throws RestException {
        return RestUtilsAuth.getJsonWithParamPath(token,
                CarrinhoVo.class,properties.getWsApi(),
                "api/v1/core/carrinho");

    }

    public CarrinhoVo removeItemCarrinho(Token token, Long idItem) throws RestException {
        return RestUtilsAuth.delete(token,CarrinhoVo.class,
                properties.getWsApi(), "api/v1/core/carrinho/removeItem",idItem.toString());
    }

    public ResultadoPagamentoVo pagamento(CheckoutForm form) throws RestException {
        return RestUtilsApp.postJson(ResultadoPagamentoVo.class,
                properties.getWsApi(), "api/v1/core/pagamento",
                ObjectUtils.toJson(form));
    }

    public CheckoutVo addCupom(Long idCheckout, String cupom) throws RestException {
        return RestUtilsApp.post(CheckoutVo.class,
                properties.getWsApi(), "api/v1/core/checkout/addCupom",
                idCheckout.toString(), cupom);
    }

    public CheckoutVo alterarEndereco(Long idCheckout, Long idEndereco) throws RestException {
        return RestUtilsApp.post(CheckoutVo.class,
                properties.getWsApi(), "api/v1/core/checkout/alterarEndereco",
                idCheckout.toString(), idEndereco.toString());
    }

    public CheckoutVo alterarFrete(Long idCheckout, String tipoFrete) throws RestException {
        return RestUtilsApp.post(CheckoutVo.class,
                properties.getWsApi(), "api/v1/core/checkout/alterarFrete",
                idCheckout.toString(), tipoFrete);
    }

    public List<ImagemExclusivaVo> listImagensExclusivas(Long idCatalogo) throws RestException {
        return Arrays.asList(RestUtilsApp.getJsonWithParamPath(
                ImagemExclusivaVo[].class,properties.getWsApi(),
                "api/v1/core/imagensExclusivas/byCatalogo",
                idCatalogo.toString()));

    }
}
