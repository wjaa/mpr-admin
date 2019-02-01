package br.com.mpr.admin.vo;

import java.util.Date;

/**
 * Created by wagner on 31/01/19.
 */
public class ResultFreteVo {

    private Boolean selecionado;
    private Integer diasUteis;
    private Double valor;
    private Date previsaoEntrega;
    private String messageError;
    private FreteType freteType;

    public Boolean getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Integer getDiasUteis() {
        return diasUteis;
    }

    public void setDiasUteis(Integer diasUteis) {
        this.diasUteis = diasUteis;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public FreteType getFreteType() {
        return freteType;
    }

    public void setFreteType(FreteType freteType) {
        this.freteType = freteType;
    }
}
