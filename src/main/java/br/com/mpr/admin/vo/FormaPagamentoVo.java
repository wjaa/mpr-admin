package br.com.mpr.admin.vo;

/**
 * Created by wagner on 02/02/19.
 */
public class FormaPagamentoVo {

    private String pagamentoType;
    private CartaoCreditoVo cartaoCredito;

    public String getPagamentoType() {
        return pagamentoType;
    }

    public void setPagamentoType(String pagamentoType) {
        this.pagamentoType = pagamentoType;
    }

    public CartaoCreditoVo getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCreditoVo cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
}
