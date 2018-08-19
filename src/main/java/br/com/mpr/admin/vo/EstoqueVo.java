package br.com.mpr.admin.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wagner on 13/06/18.
 */
public class EstoqueVo implements Serializable {

    private Long id;
    private ProdutoVo produto;
    private Long idProduto;
    private Long idFornecedor;
    private FornecedorVo fornecedor;
    private Date dataCompra;
    private Date dataAtualizacao;
    private Double precoCompra;
    private Boolean invalido;
    private String observacao;
    private Integer quantidade;
    private List<ProdutoVo> produtos;
    private List<FornecedorVo> fornecedores;

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

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Boolean getInvalido() {
        return invalido;
    }

    public void setInvalido(Boolean invalido) {
        this.invalido = invalido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoVo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVo produto) {
        this.produto = produto;
    }

    public FornecedorVo getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorVo fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ProdutoVo> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVo> produtos) {
        this.produtos = produtos;
    }

    public List<FornecedorVo> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<FornecedorVo> fornecedores) {
        this.fornecedores = fornecedores;
    }
}

