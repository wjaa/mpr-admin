package br.com.mpr.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by wagner on 31/01/19.
 */
public class ItemCarrinhoForm {

    private Long idCliente;
    @NotNull(message = "Produto é obrigatório!")
    private Long idProduto;
    private byte[] foto;
    @JsonIgnore
    private MultipartFile fotoCliente;
    private String nomeArquivo;
    private Long idCatalogo;
    private Long idCarrinho;


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public MultipartFile getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(MultipartFile fotoCliente) {
        this.fotoCliente = fotoCliente;
    }
}
