package com.tweener.apiclient.methods.parsers.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.tweener.apiclient.methods.parsers.APIResponseParser;

public class JSONParser implements APIResponseParser
{

    @Override
    public ResponseEntity< ? > parse(final String url, final HttpMethod method,
        final HttpEntity< ? > entity, final Class< ? > clazz)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
