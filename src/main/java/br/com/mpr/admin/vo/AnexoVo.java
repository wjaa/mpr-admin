package br.com.mpr.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wagner on 04/02/19.
 */
public class AnexoVo {

    private Long id;
    private byte[] foto;
    private String nomeArquivo;
    private String urlFoto;
    private Long idCatalogo;
    @JsonIgnore
    private MultipartFile fotoCliente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public MultipartFile getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(MultipartFile fotoCliente) {
        this.fotoCliente = fotoCliente;
    }
}
