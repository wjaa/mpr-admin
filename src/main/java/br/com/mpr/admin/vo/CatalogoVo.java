package br.com.mpr.admin.vo;

import br.com.mpr.admin.annotation.IgnoreCopy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * Imagem exclusiva
 */
public class CatalogoVo implements Serializable {

    private Long id;
    private Long idCatalogoGrupo;
    private String descricao;
    @IgnoreCopy
    private String img;
    private CatalogoGrupoVo catalogoGrupo;
    private byte [] byteImg;
    private String nameImg;
    @IgnoreCopy
    private List<CatalogoGrupoVo> listCatalogoGrupo;
    @JsonIgnore
    private MultipartFile fileImg;
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCatalogoGrupo() {
        return idCatalogoGrupo;
    }

    public void setIdCatalogoGrupo(Long idCatalogoGrupo) {
        this.idCatalogoGrupo = idCatalogoGrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CatalogoGrupoVo getCatalogoGrupo() {
        return catalogoGrupo;
    }

    public void setCatalogoGrupo(CatalogoGrupoVo catalogoGrupo) {
        this.catalogoGrupo = catalogoGrupo;
    }

    public byte[] getByteImg() {
        return byteImg;
    }

    public void setByteImg(byte[] byteImg) {
        this.byteImg = byteImg;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public List<CatalogoGrupoVo> getListCatalogoGrupo() {
        return listCatalogoGrupo;
    }

    public void setListCatalogoGrupo(List<CatalogoGrupoVo> listCatalogoGrupo) {
        this.listCatalogoGrupo = listCatalogoGrupo;
    }

    public MultipartFile getFileImg() {
        return fileImg;
    }

    public void setFileImg(MultipartFile fileImg) {
        this.fileImg = fileImg;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
