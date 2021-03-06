package br.com.mpr.admin.vo;

import java.util.List;

/**
 * Created by wagner on 31/01/19.
 */
public class ItemCarrinhoVo {

    private Long id;
    private Long idCarrinho;
    private ProdutoVo produto;
    private List<AnexoVo> anexos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public ProdutoVo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVo produto) {
        this.produto = produto;
    }

    public List<AnexoVo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<AnexoVo> anexos) {
        this.anexos = anexos;
    }
}
