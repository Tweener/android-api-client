package com.tweener.apiclient;

public class UserSession
{
    private String username;

    private String password;

    public UserSession(final String username, final String password)
    {
        setUsername(username);
        setPassword(password);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }
}
