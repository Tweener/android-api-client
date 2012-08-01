package com.tweener.apiclient.methods.parsers.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.tweener.apiclient.methods.parsers.APIResponseParser;

public class XMLParser implements APIResponseParser
{

    @Override
    public ResponseEntity< ? > parse(final String url, final HttpMethod method,
        final HttpEntity< ? > entity, final Class< ? > clazz)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());

        return restTemplate.exchange(url, HttpMethod.GET, entity, clazz);
    }

}
