package br.com.mpr.admin.utils;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.vo.ErrorMessageVo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

/**
 * Created by wagner on 16/06/15.
 */
public class RestUtils {

    private static final Log LOG = LogFactory.getLog(RestUtils.class);
    private static final CloseableHttpClient httpclient = HttpClients.createDefault();
    private static final ObjectMapper mapper = new ObjectMapper();


    public static <T>T getJsonWithParamPath(Class<T> clazzReturn, String targetUrl, String ... params) throws
            RestException {


        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet("http://" + targetUrl + "/" + RestUtils.createParamsPath(params));
            response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode >= 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode >= 500 && statusCode < 600){
                throw new RestException(mapper.readValue(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return mapper.readValue(EntityUtils.toString(response.getEntity()), clazzReturn);

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

    public static <T>T postJson(Class<T> clazzReturn, String targetUrl, String uri, String json) throws RestException {


        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost("http://" + targetUrl + "/" + uri);
            httpPost.setEntity(new StringEntity(json, ContentType.create("application/json", Consts.UTF_8)));
            response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode >= 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode >= 500 && statusCode < 600){
                throw new RestException(mapper.readValue(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return mapper.readValue(EntityUtils.toString(response.getEntity()), clazzReturn);

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


    public static <T>T postParam(Class<T> clazzReturn, String targetUrl,
                                 String uri, String[] paramnames, String[] values) throws RestException{

        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost("http://" + targetUrl + "/" + uri);

            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            for (int i = 0; i < paramnames.length; i ++){
                postParameters.add(new BasicNameValuePair(paramnames[i], values[i]));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
            response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            if ( statusCode >= 400 && statusCode < 500){
                LOG.error("Error code:" + statusCode + " response: " + response);
                throw new RestException(statusCode,"Servico está fora do ar ou a requisição falhou.");
            }

            if (statusCode >= 500 && statusCode < 600){
                throw new RestException(mapper.readValue(EntityUtils.toString(response.getEntity()), ErrorMessageVo.class));
            }

            LOG.debug("m=getJsonWithParamPath Response: " + response.getStatusLine());

            return mapper.readValue(EntityUtils.toString(response.getEntity()), clazzReturn);

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
}

