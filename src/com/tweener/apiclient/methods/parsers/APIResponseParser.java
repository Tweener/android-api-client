package com.tweener.apiclient.methods.parsers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface APIResponseParser
{
    public ResponseEntity< ? > parse(String url, HttpMethod method, HttpEntity< ? > entity,
        Class< ? > clazz);
}
