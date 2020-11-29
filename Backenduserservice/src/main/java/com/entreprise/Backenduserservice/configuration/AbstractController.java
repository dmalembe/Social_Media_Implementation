package com.entreprise.Backenduserservice.configuration;

import org.springframework.http.HttpHeaders;

public class AbstractController <T> {

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return headers;
    }
}
