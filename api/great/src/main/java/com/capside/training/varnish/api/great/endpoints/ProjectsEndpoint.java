package com.capside.training.varnish.api.great.endpoints;

import com.capside.training.varnish.api.common.model.Project;
import com.capside.training.varnish.api.common.services.ProjectService;
import com.capside.training.varnish.api.common.services.ProjectService;
import com.capside.training.varnish.api.great.dtos.ProjectDTO;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
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
    public Response getProjects(@HeaderParam("accept-language")String language) {
        Response response;

        Set<Project> projects = projectService.getProjects();
        if (projects.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            Set<ProjectDTO> projectsDTO = new HashSet<>();
            projects.forEach(project->{projectsDTO.add(new ProjectDTO(project,language));});
            response = Response.ok().entity(projectsDTO).build();
        }

        return response;
    }

    @GET
    @Path("/{projectIdentifier}")
    @Cache(maxAge = 600)
    public Response getProject(@PathParam("projectIdentifier") String identifier,@HeaderParam("accept-language")String language) {
        Response response;

        Optional<Project> project = projectService.getProject(identifier);
        if (project.isPresent()) {
            response = Response.ok().entity(new ProjectDTO(project.get(), language)).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
