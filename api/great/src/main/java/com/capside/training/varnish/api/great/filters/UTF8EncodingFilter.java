package com.capside.training.varnish.api.great.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Arrays;

/**
 * Ensures the content is in UTF-8
 */
@Provider
public class UTF8EncodingFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().put("Content-Encoding", Arrays.asList("utf-8"));
    }
}
