package com.capside.training.varnish.api.great.endpoints;

import com.capside.training.varnish.api.common.model.Client;
import com.capside.training.varnish.api.common.services.ClientService;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.Set;


@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientsEndpoint {
    private ClientService clientService;

    public ClientsEndpoint() {
        clientService = ClientService.get();
    }

    @GET
    @Cache(maxAge = 600)
    public Response getClients() {
        Response response;

        Set<Client> clients = clientService.getClients();
        if (clients.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(clients).build();
        }

        return response;
    }

    @GET
    @Path("/{clientIdentifier}")
    @Cache(maxAge = 600)
    public Response getClient(@PathParam("clientIdentifier") String identifier) {
        Response response;

        Optional<Client> client = clientService.getClient(identifier);
        if (client.isPresent()) {
            response = Response.ok().entity(client.get()).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
