package br.com.mpr.admin.service;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.utils.RestUtilsAuth;
import br.com.mpr.admin.utils.Token;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final Log log = LogFactory.getLog(AuthService.class);

    public Token auth(String username, String password){
        try{
            return RestUtilsAuth.getAuthToken(username, password);
        } catch (RestException e) {
            log.error("Erro na autenticacao do usuário", e);
        }
        return null;
    }

}
