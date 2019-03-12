package br.com.mpr.admin.vo;

import java.util.List;

/**
 *
 */
public class ItemPedidoVo {

    private Long id;
    private Long idPedido;
    private Long idProduto;
    private Double valor;
    private Long idEstoque;
    private List<ItemPedidoAnexoVo> anexos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public List<ItemPedidoAnexoVo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<ItemPedidoAnexoVo> anexos) {
        this.anexos = anexos;
    }
}
