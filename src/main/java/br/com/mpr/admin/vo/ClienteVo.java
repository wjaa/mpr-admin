package br.com.mpr.admin.vo;

import br.com.mpr.admin.helper.JacksonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wagner on 04/06/18.
 */
public class ClienteVo implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private List<EnderecoVo> enderecos;
    private String celular;
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    private Date aniversario;
    private String genero;
    private Boolean ativo;
    private LoginVo login;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf != null ? cpf.replaceAll("[^\\d]", "") : null;
    }


    public List<EnderecoVo> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoVo> enderecos) {
        this.enderecos = enderecos;
    }


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LoginVo getLogin() {
        return login;
    }

    public void setLogin(LoginVo login) {
        this.login = login;
    }
}
