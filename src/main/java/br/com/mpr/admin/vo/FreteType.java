package br.com.mpr.admin.vo;

/**
 * Created by wagner on 31/01/19.
 */
public enum FreteType {

    ECONOMICO("Padrão"),
    RAPIDO("Express"),

    ;
    private String descricao;

    FreteType(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
