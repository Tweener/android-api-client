package com.tweener.apiclient.methods;

import com.tweener.apiclient.UserSession;

public interface APIRequest
{
    public Object get(final UserSession userSession, final String uri, Class< ? > clazz,
        final String accept) throws Exception;

    public Object post() throws Exception;
}
