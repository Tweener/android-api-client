package com.tweener.apiclient.methods.impl;

import java.util.Collections;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tweener.apiclient.UserSession;
import com.tweener.apiclient.exceptions.APIHttpRequestException;
import com.tweener.apiclient.methods.APIRequest;
import com.tweener.apiclient.utils.SSLUtils;

public class APIRequestImpl implements APIRequest
{
    public APIRequestImpl()
    {

    }

    @Override
    public Object get(final UserSession userSession, final String uri, final Class< ? > clazz,
        final String accept) throws Exception
    {
        try
        {
            if (uri.startsWith("https"))
            {
                SSLUtils.installIgnoreCertTrustManager();
            }

            // Set the username and password for creating a Basic Auth request
            HttpAuthentication authHeader =
                new HttpBasicAuthentication(userSession.getUsername(), userSession.getPassword());

            // Set the headers
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAccept(Collections
                .singletonList(new MediaType("application", accept)));
            requestHeaders.setAuthorization(authHeader);

            HttpEntity< ? > requestEntity = new HttpEntity<Object>(requestHeaders);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());

            ResponseEntity< ? > responseEntity =
                restTemplate.exchange(uri, HttpMethod.GET, requestEntity, clazz);

            return responseEntity.getBody();
        }
        catch (HttpClientErrorException e)
        {
            switch (e.getStatusCode())
            {
                case UNAUTHORIZED:
                    throw new APIHttpRequestException(e.getStatusCode(),
                        "Incorrect user or password");

                default:
                    throw new APIHttpRequestException(e.getStatusCode(), e.getMessage());
            }
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Object post() throws Exception
    {
        // try
        // {
        // if (getUri().startsWith("https"))
        // {
        // SSLUtils.installIgnoreCertTrustManager();
        // }
        //
        // HttpPost postRequest = new HttpPost(getUri());
        //
        // postRequest.setEntity(new UrlEncodedFormEntity(getParams()));
        //
        // HttpResponse httpResponse = getHttpClient().execute(postRequest);
        // getHttpClient().getConnectionManager().shutdown();
        //
        // return processResponse(httpResponse);
        // }
        // catch (Exception e)
        // {
        // // Error trying to perform the POST
        // Log.d(Configuration.LOG_TAG, e.getMessage());
        // throw new Exception(e);
        // }

        return null;
    }
}
