package com.capside.training.varnish.api.great.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Arrays;

/**
 * If no default accept-language header has been provided (which will happen as soon
 * as we start using curl to interact with our api for the first time)
 */
@Provider
public class DefaultLanguageFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String languageHeader = containerRequestContext.getHeaderString("accept-language");
        if (languageHeader == null || languageHeader.isEmpty()) {
            containerRequestContext.getHeaders().put("accept-language", Arrays.asList("en"));
        }
    }
}
