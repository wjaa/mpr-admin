package br.com.mpr.admin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mpr")
public class MprAdminProperties {

    private String wsApi;

    public String getWsApi() {
        return wsApi;
    }

    public void setWsApi(String wsApi) {
        this.wsApi = wsApi;
    }
}
