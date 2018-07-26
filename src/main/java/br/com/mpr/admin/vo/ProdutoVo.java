package br.com.mpr.admin.vo;

/**
 * Created by wagner on 04/06/18.
 */
public class ProdutoVo {

    private Long id;
    private Long idTipoProduto;
    private TipoProdutoVo tipo;
    private String descricao;
    private Double peso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public TipoProdutoVo getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoVo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
