package br.com.mpr.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by wagner on 31/01/19.
 */
public class ItemCarrinhoForm {

    private Long idCliente;
    @NotNull(message = "Produto é obrigatório!")
    private Long idProduto;
    private List<AnexoVo> anexos;
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

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public List<AnexoVo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<AnexoVo> anexos) {
        this.anexos = anexos;
    }
}
