package br.com.mpr.admin.vo;

/**
 *
 */
public class ProdutoImagemDestaqueVo {

    private Long id;
    private String img;
    private byte [] byteImgDestaque;
    private String nameImgDestaque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
}
