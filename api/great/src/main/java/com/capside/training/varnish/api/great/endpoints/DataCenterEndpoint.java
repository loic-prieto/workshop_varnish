package com.capside.training.varnish.api.great.endpoints;

import com.capside.training.varnish.api.common.model.Client;
import com.capside.training.varnish.api.common.model.DataCenter;
import com.capside.training.varnish.api.common.services.DataCenterService;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getDataCenters() {
        Response response;

        Set<DataCenter> dataCenters = dataCenterService.getDataCenters();
        if (dataCenters.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(dataCenters).build();
        }

        return response;
    }

    @GET
    @Path("/{dataCenterIdentifier}")
    @Cache(maxAge = 600)
    public Response getDatacenter(@PathParam("dataCenterIdentifier") String identifier) {
        Response response;

        Optional<DataCenter> dataCenter = dataCenterService.getDataCenter(identifier);
        if (dataCenter.isPresent()) {
            response = Response.ok().entity(dataCenter.get()).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
