package br.com.mpr.admin.vo;

import br.com.mpr.admin.annotation.IgnoreCopy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wagner on 04/06/18.
 */
public class ProdutoVo implements Serializable {

    private Long id;
    private Long idTipoProduto;
    private TipoProdutoVo tipo;
    private String descricao;
    private String descricaoDetalhada;
    private Double peso;
    private String referencia;
    @IgnoreCopy
    private List<TipoProdutoVo> listTipoProdutos;
    @IgnoreCopy
    private String imgDestaque;
    @IgnoreCopy
    private String imgPreview;
    @IgnoreCopy
    private String imgPreviewPaisagem;
    private byte [] byteImgDestaque;
    private String nameImgDestaque;
    private byte [] byteImgPreview;
    private String nameImgPreview;
    private byte [] byteImgPreviewPaisagem;
    private String nameImgPreviewPaisagem;
    @JsonIgnore
    private MultipartFile destaque;
    @JsonIgnore
    private MultipartFile preview;

    @JsonIgnore
    private MultipartFile previewPaisagem;
    private String nomeCor;
    private String hexaCor;
    private Double preco;
    private String nomeTipoProduto;
    private Integer estoqueMinimo;
    private Boolean ativo;
    private Double comp;
    private Double larg;
    private Double alt;
    private Boolean lancamento;
    private Boolean popular;
    private Integer qtdeFotos;
    @JsonIgnore
    private MultipartFile [] listDestaque;

    private List<ProdutoImagemDestaqueVo> listImgDestaque;
    private List<String> imagensDestaque;


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

    public List<TipoProdutoVo> getListTipoProdutos() {
        return listTipoProdutos;
    }

    public void setListTipoProdutos(List<TipoProdutoVo> listTipoProdutos) {
        this.listTipoProdutos = listTipoProdutos;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getImgDestaque() {
        return imgDestaque;
    }

    public void setImgDestaque(String imgDestaque) {
        this.imgDestaque = imgDestaque;
    }

    public String getImgPreview() {
        return imgPreview;
    }

    public void setImgPreview(String imgPreview) {
        this.imgPreview = imgPreview;
    }

    public byte[] getByteImgDestaque() {
        return byteImgDestaque;
    }

    public void setByteImgDestaque(byte[] byteImgDestaque) {
        this.byteImgDestaque = byteImgDestaque;
    }

    public String getNameImgDestaque() {
        return nameImgDestaque;
    }

    public void setNameImgDestaque(String nameImgDestaque) {
        this.nameImgDestaque = nameImgDestaque;
    }

    public byte[] getByteImgPreview() {
        return byteImgPreview;
    }

    public void setByteImgPreview(byte[] byteImgPreview) {
        this.byteImgPreview = byteImgPreview;
    }

    public String getNameImgPreview() {
        return nameImgPreview;
    }

    public void setNameImgPreview(String nameImgPreview) {
        this.nameImgPreview = nameImgPreview;
    }

    public MultipartFile getDestaque() {
        return destaque;
    }

    public void setDestaque(MultipartFile destaque) {
        this.destaque = destaque;
    }

    public MultipartFile getPreview() {
        return preview;
    }

    public void setPreview(MultipartFile preview) {
        this.preview = preview;
    }


    public String getNomeCor() {
        return nomeCor;
    }

    public void setNomeCor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    public String getHexaCor() {
        return hexaCor;
    }

    public void setHexaCor(String hexaCor) {
        this.hexaCor = hexaCor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNomeTipoProduto() {
        return nomeTipoProduto;
    }

    public void setNomeTipoProduto(String nomeTipoProduto) {
        this.nomeTipoProduto = nomeTipoProduto;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public Boolean getAtivo() {
        return ativo == null ? false : ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    public List<ProdutoImagemDestaqueVo> getListImgDestaque() {
        return listImgDestaque;
    }

    public void setListImgDestaque(List<ProdutoImagemDestaqueVo> listImgDestaque) {
        this.listImgDestaque = listImgDestaque;
    }

    public MultipartFile[] getListDestaque() {
        return listDestaque;
    }

    public void setListDestaque(MultipartFile[] listDestaque) {
        this.listDestaque = listDestaque;
    }

    public Double getComp() {
        return comp;
    }

    public void setComp(Double comp) {
        this.comp = comp;
    }

    public Double getLarg() {
        return larg;
    }

    public void setLarg(Double larg) {
        this.larg = larg;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
    }

    public Boolean getLancamento() {
        return lancamento;
    }

    public void setLancamento(Boolean lancamento) {
        this.lancamento = lancamento;
    }

    public Boolean getPopular() {
        return popular;
    }

    public void setPopular(Boolean popular) {
        this.popular = popular;
    }

    public List<String> getImagensDestaque() {
        return imagensDestaque;
    }

    public void setImagensDestaque(List<String> imagensDestaque) {
        this.imagensDestaque = imagensDestaque;
    }

    public Integer getQtdeFotos() {
        return qtdeFotos;
    }

    public void setQtdeFotos(Integer qtdeFotos) {
        this.qtdeFotos = qtdeFotos;
    }

    public String getImgPreviewPaisagem() {
        return imgPreviewPaisagem;
    }

    public void setImgPreviewPaisagem(String imgPreviewPaisagem) {
        this.imgPreviewPaisagem = imgPreviewPaisagem;
    }

    public byte[] getByteImgPreviewPaisagem() {
        return byteImgPreviewPaisagem;
    }

    public void setByteImgPreviewPaisagem(byte[] byteImgPreviewPaisagem) {
        this.byteImgPreviewPaisagem = byteImgPreviewPaisagem;
    }

    public String getNameImgPreviewPaisagem() {
        return nameImgPreviewPaisagem;
    }

    public void setNameImgPreviewPaisagem(String nameImgPreviewPaisagem) {
        this.nameImgPreviewPaisagem = nameImgPreviewPaisagem;
    }

    public MultipartFile getPreviewPaisagem() {
        return previewPaisagem;
    }

    public void setPreviewPaisagem(MultipartFile previewPaisagem) {
        this.previewPaisagem = previewPaisagem;
    }
}
