package com.bemarzprj.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityConstants
{
    public static final long JWT_EXPIRATION = 1000000;
    public static final String JWT_SECRET = "secret";

    public static Authentication getAuth()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
