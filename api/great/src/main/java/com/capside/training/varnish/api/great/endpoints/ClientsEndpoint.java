package com.capside.training.varnish.api.great.endpoints;

import com.capside.training.varnish.api.common.model.Client;
import com.capside.training.varnish.api.common.services.ClientService;
import com.capside.training.varnish.api.great.dtos.ClientDTO;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
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
    public Response getClients(@HeaderParam("accept-language")String language) {
        Response response;

        Set<Client> clients = clientService.getClients();
        if (clients.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            Set<ClientDTO> clientsDTO = new HashSet<>();
            clients.forEach(client->{
                clientsDTO.add(new ClientDTO(client,language));
            });
            response = Response.ok().entity(clientsDTO).build();
        }

        return response;
    }

    @GET
    @Path("/{clientIdentifier}")
    @Cache(maxAge = 600)
    public Response getClient(@PathParam("clientIdentifier") String identifier,@HeaderParam("accept-language")String language) {
        Response response;

        Optional<Client> client = clientService.getClient(identifier);
        if (client.isPresent()) {
            response = Response.ok().entity(new ClientDTO(client.get(), language)).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
