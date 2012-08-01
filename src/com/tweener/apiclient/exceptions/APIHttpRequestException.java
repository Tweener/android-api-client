package com.tweener.apiclient.exceptions;

import org.springframework.http.HttpStatus;

public class APIHttpRequestException extends Exception
{
    private static final long serialVersionUID = -6863749794206772110L;

    private HttpStatus statusCode;

    private String messageError;

    public APIHttpRequestException(final HttpStatus statusCode)
    {
        setStatusCode(statusCode);
        setMessageError(null);
    }

    public APIHttpRequestException(final HttpStatus statusCode, final String messageError)
    {
        setStatusCode(statusCode);
        setMessageError(messageError);
    }

    public APIHttpRequestException(final APIHttpRequestException e)
    {
        setStatusCode(e.getStatusCode());
        setMessageError(e.getMessageError() != null ? e.getMessageError() : null);
    }

    public void setStatusCode(final HttpStatus statusCode)
    {
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode()
    {
        return statusCode;
    }

    public void setMessageError(final String messageError)
    {
        this.messageError = messageError;
    }

    public String getMessageError()
    {
        return messageError;
    }

    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();

        string.append(getStatusCode());
        string.append(" ");
        string.append(getStatusCode().getReasonPhrase());
        string.append(": ");

        if (getMessageError() != null)
        {
            string.append(getMessageError());
        }

        return string.toString();
    }
}
