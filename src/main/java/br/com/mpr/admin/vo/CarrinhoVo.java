package br.com.mpr.admin.vo;

import java.util.List;

/**
 * Created by wagner on 31/01/19.
 */
public class CarrinhoVo {

    private Long idCarrinho;
    private Long idCliente;
    private String keyDevice;
    private List<ItemCarrinhoVo> items;
    private ResultFreteVo resultFrete;
    private Integer totalItens;
    private Double valorFrete;
    private Double valorItens;
    private Double valorTotalCarrinho;

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getKeyDevice() {
        return keyDevice;
    }

    public void setKeyDevice(String keyDevice) {
        this.keyDevice = keyDevice;
    }

    public List<ItemCarrinhoVo> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrinhoVo> items) {
        this.items = items;
    }

    public ResultFreteVo getResultFrete() {
        return resultFrete;
    }

    public void setResultFrete(ResultFreteVo resultFrete) {
        this.resultFrete = resultFrete;
    }

    public Integer getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(Integer totalItens) {
        this.totalItens = totalItens;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Double getValorItens() {
        return valorItens;
    }

    public void setValorItens(Double valorItens) {
        this.valorItens = valorItens;
    }

    public Double getValorTotalCarrinho() {
        return valorTotalCarrinho;
    }

    public void setValorTotalCarrinho(Double valorTotalCarrinho) {
        this.valorTotalCarrinho = valorTotalCarrinho;
    }
}
