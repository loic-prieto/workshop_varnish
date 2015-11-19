package com.capside.training.varnish.api.great.endpoints;

import com.capside.training.varnish.api.common.model.Client;
import com.capside.training.varnish.api.common.model.DataCenter;
import com.capside.training.varnish.api.common.services.DataCenterService;
import com.capside.training.varnish.api.great.dtos.DataCenterDTO;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Path("/datacenters")
@Produces(MediaType.APPLICATION_JSON)
public class DataCenterEndpoint {

    private DataCenterService dataCenterService;

    public DataCenterEndpoint() {
        this.dataCenterService = DataCenterService.get();
    }

    @GET
    @Cache(maxAge = 600)
    public Response getDataCenters(@HeaderParam("accept-language")String language) {
        Response response;

        Set<DataCenter> dataCenters = dataCenterService.getDataCenters();
        if (dataCenters.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            Set<DataCenterDTO> dataCentersDTO = new HashSet<>();
            dataCenters.forEach(dataCenter->{dataCentersDTO.add(new DataCenterDTO(dataCenter,language));});
            response = Response.ok().entity(dataCentersDTO).build();
        }

        return response;
    }

    @GET
    @Path("/{dataCenterIdentifier}")
    @Cache(maxAge = 600)
    public Response getDatacenter(@PathParam("dataCenterIdentifier") String identifier,@HeaderParam("accept-language")String language) {
        Response response;

        Optional<DataCenter> dataCenter = dataCenterService.getDataCenter(identifier);
        if (dataCenter.isPresent()) {
            response = Response.ok().entity(new DataCenterDTO(dataCenter.get(), language)).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
