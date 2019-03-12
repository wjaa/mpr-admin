package br.com.mpr.admin.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by wagner on 02/02/19.
 */
public class PedidoVo {


    private Long id;
    private String codigoPedido;
    private String codigoTransacao;
    private Date data;
    private Long idCliente;
    private ClienteVo cliente;
    private Long idEndereco;
    private Long idCupom;
    private CupomVo cupom;
    private List<ItemPedidoVo> itens;
    private Double valorProdutos;
    private Double valorFrete;
    private Double valorDesconto;
    private Double valorTotal;
    private String codigoRastreio;
    private FreteType TipoFrete;
    private PagamentoType pagamentoType;
    private Date dataEntrega;
    private StatusPedidoVo statusAtual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Long getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(Long idCupom) {
        this.idCupom = idCupom;
    }

    public List<ItemPedidoVo> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoVo> itens) {
        this.itens = itens;
    }

    public Double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(Double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public FreteType getTipoFrete() {
        return TipoFrete;
    }

    public void setTipoFrete(FreteType tipoFrete) {
        TipoFrete = tipoFrete;
    }

    public PagamentoType getPagamentoType() {
        return pagamentoType;
    }

    public void setPagamentoType(PagamentoType pagamentoType) {
        this.pagamentoType = pagamentoType;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusPedidoVo getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(StatusPedidoVo statusAtual) {
        this.statusAtual = statusAtual;
    }

    public ClienteVo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVo cliente) {
        this.cliente = cliente;
    }

    public CupomVo getCupom() {
        return cupom;
    }

    public void setCupom(CupomVo cupom) {
        this.cupom = cupom;
    }
}
