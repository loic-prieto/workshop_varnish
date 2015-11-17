package com.capside.training.varnish.api.great.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Arrays;

/**
 * The application knows best what header fields make a request
 * be unique. So, we specify it here.
 * What may change the content is:
 * - Accept (for JSON or XML representation)
 * - Accept-Language
 * - Cookie (authorization cookie, for example)
 */
@Provider
public class VaryHeaderFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().put("Vary", Arrays.asList("Accept","Accept-Language","Cookie"));
    }
}
