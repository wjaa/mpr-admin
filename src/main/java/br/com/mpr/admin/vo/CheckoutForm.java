package br.com.mpr.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by wagner on 02/02/19.
 */
public class CheckoutForm {
    private Long idCheckout;
    private FormaPagamentoVo formaPagamento;
    private String senderHash;
    @JsonIgnore
    private Long idCarrinho;

    public Long getIdCheckout() {
        return idCheckout;
    }

    public void setIdCheckout(Long idCheckout) {
        this.idCheckout = idCheckout;
    }

    public FormaPagamentoVo getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoVo formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getSenderHash() {
        return senderHash;
    }

    public void setSenderHash(String senderHash) {
        this.senderHash = senderHash;
    }
}
