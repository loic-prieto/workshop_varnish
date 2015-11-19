package com.capside.training.varnish.api.great.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;

/**
 * Will only apply to employees endpoint, uses basic authentication with no validation whatsoever,
 * so a "Authentication: lol" will suffice.
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter{
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String uri = containerRequestContext.getUriInfo().getPath();
        if(uri.matches("^/employees$")){
            List<String> authenticationHeader = containerRequestContext.getHeaders().get("Authorization");
            if(authenticationHeader == null || authenticationHeader.isEmpty()){
                containerRequestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
            }
        }
    }
}
