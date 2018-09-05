package br.com.mpr.admin.vo;

import br.com.mpr.admin.annotation.IgnoreCopy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wagner on 04/06/18.
 */
public class TabelaPrecoVo implements Serializable {

    private Long id;
    private Long idProduto;
    private Date dataVigencia;
    private Double preco;
    private String descricao;
    @IgnoreCopy
    private ProdutoVo produto;
    @IgnoreCopy
    private List<ProdutoVo> produtos;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Date getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(Date dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProdutoVo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVo produto) {
        this.produto = produto;
    }

    public List<ProdutoVo> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVo> produtos) {
        this.produtos = produtos;
    }
}