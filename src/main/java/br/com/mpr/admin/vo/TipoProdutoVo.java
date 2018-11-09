package br.com.mpr.admin.vo;

import java.io.Serializable;

/**
 * Created by wagner on 04/06/18.
 */
public class TipoProdutoVo implements Serializable {

    private Long id;
    private String descricao;
    private Boolean acessorio;

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

    public Boolean getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Boolean acessorio) {
        this.acessorio = acessorio;
    }
}
