package br.com.mpr.admin.vo;

import br.com.mpr.admin.utils.Token;

public class AuthVo {


    private String username;
    private String password;
    private Token token;

    public AuthVo(){}

    public AuthVo(String username, Token token){
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
