package com.ibm.SerasaProject.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public JwtAuthenticationToken(String username) {
        super(username, null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
