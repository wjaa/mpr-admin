package br.com.mpr.admin.service;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.properties.MprAdminProperties;
import br.com.mpr.admin.utils.ObjectUtils;
import br.com.mpr.admin.utils.RestUtils;
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
        return RestUtils.get(properties.getWsApi(), "api/v1/core/checkout/token");
    }

    public CarrinhoVo addItemCarrinho(ItemCarrinhoForm item) throws RestException {
        return RestUtils.putJson(CarrinhoVo.class,
                properties.getWsApi(), "api/v1/core/carrinho/add",
                ObjectUtils.toJson(item));
    }

    public CheckoutVo checkout(Long idCarrinho) throws RestException {
        return RestUtils.getJsonWithParamPath(
                CheckoutVo.class,properties.getWsApi(), "api/v1/core/checkout", idCarrinho.toString());
    }

    public CarrinhoVo getCarrinhoByIdCliente(Long idCliente) throws RestException {
        return RestUtils.getJsonWithParamPath(
                CarrinhoVo.class,properties.getWsApi(),
                "api/v1/core/carrinho/byIdCliente",
                idCliente.toString());

    }

    public CarrinhoVo removeItemCarrinho(Long idItem) throws RestException {
        return RestUtils.delete(CarrinhoVo.class,
                properties.getWsApi(), "api/v1/core/carrinho/removeItem",idItem.toString());
    }

    public ResultadoPagamentoVo pagamento(CheckoutForm form) throws RestException {
        return RestUtils.postJson(ResultadoPagamentoVo.class,
                properties.getWsApi(), "api/v1/core/pagamento",
                ObjectUtils.toJson(form));
    }

    public CheckoutVo addCupom(Long idCheckout, String cupom) throws RestException {
        return RestUtils.post(CheckoutVo.class,
                properties.getWsApi(), "api/v1/core/checkout/addCupom",
                idCheckout.toString(), cupom);
    }

    public CheckoutVo alterarEndereco(Long idCheckout, Long idEndereco) throws RestException {
        return RestUtils.post(CheckoutVo.class,
                properties.getWsApi(), "api/v1/core/checkout/alterarEndereco",
                idCheckout.toString(), idEndereco.toString());
    }

    public CheckoutVo alterarFrete(Long idCheckout, String tipoFrete) throws RestException {
        return RestUtils.post(CheckoutVo.class,
                properties.getWsApi(), "api/v1/core/checkout/alterarFrete",
                idCheckout.toString(), tipoFrete);
    }

    public List<ImagemExclusivaVo> listImagensExclusivas(Long idCatalogo) throws RestException {
        return Arrays.asList(RestUtils.getJsonWithParamPath(
                ImagemExclusivaVo[].class,properties.getWsApi(),
                "api/v1/core/imagensExclusivas/byCatalogo",
                idCatalogo.toString()));

    }
}
