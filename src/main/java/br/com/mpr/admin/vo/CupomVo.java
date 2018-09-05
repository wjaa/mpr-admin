package br.com.mpr.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wagner on 04/06/18.
 */
public class CupomVo implements Serializable {

    private Long id;
    private String descricao;
    private String hash;
    private Date dataInicio;
    private Date dataFim;
    private Boolean promocao;
    private Double porcentagem;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }


    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }


    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }


    public Boolean getPromocao() {
        return promocao != null ? promocao : false;
    }

    public void setPromocao(Boolean promocao) {
        this.promocao = promocao;
    }


    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }
}
