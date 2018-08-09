package br.com.mpr.admin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mpr")
public class MprAdminProperties {

    private String wsApi;
    private String wsUser;
    private String wsPass;

    public String getWsApi() {
        return wsApi;
    }

    public void setWsApi(String wsApi) {
        this.wsApi = wsApi;
    }

    public String getWsUser() {
        return wsUser;
    }

    public void setWsUser(String wsUser) {
        this.wsUser = wsUser;
    }

    public String getWsPass() {
        return wsPass;
    }

    public void setWsPass(String wsPass) {
        this.wsPass = wsPass;
    }
}
