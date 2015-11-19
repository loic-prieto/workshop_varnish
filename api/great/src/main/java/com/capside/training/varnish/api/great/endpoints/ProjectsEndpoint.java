package com.capside.training.varnish.api.great.endpoints;

import com.capside.training.varnish.api.common.model.Project;
import com.capside.training.varnish.api.common.services.ProjectService;
import com.capside.training.varnish.api.common.services.ProjectService;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.Set;


@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectsEndpoint {
    private ProjectService projectService;

    public ProjectsEndpoint() {
        projectService = ProjectService.get();
    }

    @GET
    @Cache(maxAge = 600)
    public Response getProjects() {
        Response response;

        Set<Project> projects = projectService.getProjects();
        if (projects.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(projects).build();
        }

        return response;
    }

    @GET
    @Path("/{projectIdentifier}")
    @Cache(maxAge = 600)
    public Response getProject(@PathParam("projectIdentifier") String identifier) {
        Response response;

        Optional<Project> project = projectService.getProject(identifier);
        if (project.isPresent()) {
            response = Response.ok().entity(project.get()).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
