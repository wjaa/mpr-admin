package br.com.mpr.admin.utils;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.properties.MprAdminProperties;
import br.com.mpr.admin.vo.ErrorMessageVo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wagner on 16/06/15.
 */
@Component
public class RestUtilsAuth {


    private static final Log LOG = LogFactory.getLog(RestUtilsAuth.class);
    private static CloseableHttpClient httpclient = null;
    private static CloseableHttpClient httpclientToken = null;
    private static MprAdminProperties properties;

    @Autowired
    private void setProperties(MprAdminProperties pr){
        properties = pr;
    }

    @PostConstruct
    private void initStaticProperties () {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials(properties.getWsUser(), properties.getWsPass());
        provider.setCredentials(AuthScope.ANY, credentials);

        //com autenticacao do ADMIN para buscar o token
        httpclientToken = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();

        //apenas para enviar o token com bear
        httpclient = HttpClientBuilder.create().build();
    }

    public static <T>T getJsonWithParamPath(Token token, Class<T> clazzReturn, String targetUrl, String ... params) throws
            RestException {


        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet( targetUrl + "/" + RestUtilsAuth.createParamsPath(params));
            httpGet.addHeader("Authorization", "Bearer " + token.getAccessToken());
            response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), clazzReturn);

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }



    public static String get(Token token, String url, String ... params) throws
            RestException {


        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet( url + "/" + RestUtilsAuth.createParamsPath(params));
            httpGet.addHeader("Authorization", "Bearer " + token.getAccessToken());
            response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return EntityUtils.toString(response.getEntity());

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }

    public static <T>T postJson(Token token, Class<T> clazzReturn, String targetUrl, String uri, String json) throws RestException {


        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost( targetUrl + "/" + uri);
            httpPost.addHeader("Authorization", "Bearer " +  token.getAccessToken());
            httpPost.setEntity(new StringEntity(json, ContentType.create("application/json", Consts.UTF_8)));
            response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=postJson Response: " + response.getStatusLine());

            return ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), clazzReturn);

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }

    public static <T>T putJson(Token token, Class<T> clazzReturn, String targetUrl, String uri, String json) throws RestException {


        CloseableHttpResponse response = null;
        try {
            HttpPut httpPut = new HttpPut( targetUrl + "/" + uri);
            httpPut.addHeader("Authorization", "Bearer " + token.getAccessToken());
            httpPut.setEntity(new StringEntity(json, ContentType.create("application/json", Consts.UTF_8)));
            response = httpclient.execute(httpPut);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), clazzReturn);

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }

    private static String createParamsPath(String[] params) {
        String result = "";
        for(String p : params){
            result += "/" + p;
        }
        return result;

    }


    public static <T>T postParam(Token token, Class<T> clazzReturn, String targetUrl,
                                 String uri, String[] paramnames, String[] values) throws RestException{

        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost( targetUrl + "/" + uri);
            httpPost.addHeader("Authorization", "Bearer " + token.getAccessToken());
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            for (int i = 0; i < paramnames.length; i ++){
                postParameters.add(new BasicNameValuePair(paramnames[i], values[i]));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
            response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), clazzReturn);

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }

    public static <T>T delete(Token token, Class<T> clazzReturn, String targetUrl, String ... params) throws
            RestException {


        CloseableHttpResponse response = null;
        try {
            HttpDelete httpDelete = new HttpDelete( targetUrl + "/" + RestUtilsAuth.createParamsPath(params));
            httpDelete.addHeader("Authorization", "Bearer " + token.getAccessToken());
            response = httpclient.execute(httpDelete);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), clazzReturn);

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }


    public static void delete(Token token, String targetUrl, String ... params) throws
            RestException {


        CloseableHttpResponse response = null;
        try {
            HttpDelete httpDelete = new HttpDelete( targetUrl + "/" + RestUtilsAuth.createParamsPath(params));

            httpDelete.addHeader("Authorization", "Bearer " + token.getAccessToken());
            response = httpclient.execute(httpDelete);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }

    public static <T>T post(Token token, Class<T> clazzReturn, String targetUrl, String ... params) throws
            RestException {


        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost( targetUrl + "/" + RestUtilsAuth.createParamsPath(params));
            httpPost.addHeader("Authorization", "Bearer " + token.getAccessToken());
            response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode > 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode == 400 || (statusCode >= 500 && statusCode < 600)){
                throw new RestException(ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return ObjectUtils.fromJSON(EntityUtils.toString(response.getEntity()), clazzReturn);

        }catch (JsonMappingException | JsonParseException e) {
            throw new RestException(500,"Erro no parser do JSON");
        } catch (RestException  e) {
            throw e;
        }  catch (Exception e) {
            throw new RestException(new ErrorMessageVo(500, e.getMessage()));
        } finally {
            try{
                if (response != null){
                    response.close();
                }
            }catch(Exception ex){
                LOG.error("Erro ao fechar a conexao.", ex);
            }

        }
    }

    public static Token getAuthToken(String username, String password) throws RestException {
        HttpPost httpPost = new HttpPost( properties.getWsApi() + "/oauth/token");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(
                    Arrays.asList(
                            new BasicNameValuePair("grant_type","password"),
                            new BasicNameValuePair("username",username),
                            new BasicNameValuePair("password",password)
                    )));
            return executePostToken(httpPost);
        }catch(RestException ex){
            throw ex;
        }catch(Exception ex){
            LOG.debug("m=getAuthToken Erro ao buscar o token",ex);
            try{
                LOG.warn("Iniciando uma nova tentativa....");
                return executePostToken(httpPost);
            }catch(Exception e){
                LOG.debug("m=getAuthToken Erro ao buscar o token",ex);
                throw new RestException(500,"Não foi possivel pegar o token");
            }
        }
    }


    private static Token executePostToken(HttpPost httpPost) throws IOException, RestException {
        CloseableHttpResponse response = httpclientToken.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 400 && statusCode < 600) {
            LOG.warn("Fazendo uma nova tentativa para buscar o token");

            response = httpclientToken.execute(httpPost);
            statusCode = response.getStatusLine().getStatusCode();

            if (statusCode > 400 && statusCode < 600) {
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode, "Servico está fora do ar ou a requisição falhou.");
            }
        }
        LOG.debug("m=getToken Response: " + response.getStatusLine());
        String json = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(json);
        return ObjectUtils.fromJSON(json, Token.class);
    }



}

