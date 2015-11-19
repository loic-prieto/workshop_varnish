package com.capside.training.varnish.api.great.endpoints;

import com.capside.training.varnish.api.common.model.Employee;
import com.capside.training.varnish.api.common.services.EmployeeService;
import com.capside.training.varnish.api.great.dtos.EmployeeDTO;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeesEndpoint {
    private EmployeeService employeeService;

    public EmployeesEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeesEndpoint() {
        this(EmployeeService.get());
    }

    @GET
    @Path("/{employeeIdentifier}")
    @Cache(maxAge = 600)
    public Response getEmployee(@PathParam("employeeIdentifier") String identifier, @HeaderParam("accept-language") String language) {
        Response response;

        Optional<Employee> employee = employeeService.getEmployee(identifier);
        if (employee.isPresent()) {
            response = Response.ok().entity(new EmployeeDTO(employee.get(), language)).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @GET
    @Cache(maxAge = 600)
    public Response getEmployees(@HeaderParam("accept-language") String language) {
        Response response;

        Set<Employee> employees = employeeService.getEmployees();
        if (employees.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            Set<EmployeeDTO> employeesDTO = new HashSet<>();
            employees.forEach(employee -> {
                employeesDTO.add(new EmployeeDTO(employee, language));
            });
            response = Response.ok().entity(employeesDTO).build();
        }

        return response;
    }
}
