package br.com.mpr.admin.vo;

import java.util.List;

/**
 * Created by wagner on 31/01/19.
 */
public class CheckoutVo {

    private Long id;
    private List<ProdutoVo> produtos;
    private EnderecoVo endereco;
    private List<ResultFreteVo> listResultFrete;
    private ResultFreteVo freteSelecionado;
    private Double valorProdutos;
    private Double valorDesconto;
    private Integer diasEntrega;
    private Double valorFrete;
    private Long idCupom;
    private Long idCarrinho;
    private Long idCliente;
    private String checkoutToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProdutoVo> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVo> produtos) {
        this.produtos = produtos;
    }

    public EnderecoVo getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoVo endereco) {
        this.endereco = endereco;
    }

    public Double getValorProdutos() {
        return valorProdutos != null ? this.valorProdutos : 0.0;
    }

    public void setValorProdutos(Double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public Double getValorTotal() {
        return this.getValorFrete() + this.getValorProdutos() - this.getValorDesconto();
    }

    public Double getValorDesconto() {
        return valorDesconto == null ? 0.0 : valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Long getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(Long idCupom) {
        this.idCupom = idCupom;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public List<ResultFreteVo> getListResultFrete() {
        return listResultFrete;
    }

    public void setListResultFrete(List<ResultFreteVo> listResultFrete) {
        this.listResultFrete = listResultFrete;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public ResultFreteVo getFreteSelecionado() {
        return freteSelecionado;
    }

    public void setFreteSelecionado(ResultFreteVo freteSelecionado) {
        this.freteSelecionado = freteSelecionado;
    }

    public Integer getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(Integer diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getCheckoutToken() {
        return checkoutToken;
    }

    public void setCheckoutToken(String checkoutToken) {
        this.checkoutToken = checkoutToken;
    }
}