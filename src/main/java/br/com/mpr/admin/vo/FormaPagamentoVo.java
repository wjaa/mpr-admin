package br.com.mpr.admin.vo;

/**
 * Created by wagner on 02/02/19.
 */
public class FormaPagamentoVo {

    private String tipoPagamento;
    private CartaoCreditoVo cartaoCredito;

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public CartaoCreditoVo getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCreditoVo cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
}
