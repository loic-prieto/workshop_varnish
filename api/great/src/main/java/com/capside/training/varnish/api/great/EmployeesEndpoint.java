package com.capside.training.varnish.api.great;

import com.capside.training.varnish.api.common.model.Employee;
import com.capside.training.varnish.api.common.services.EmployeeService;
import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getEmployee(@PathParam("employeeIdentifier") String identifier) {
        Response response;

        Optional<Employee> employee = employeeService.getEmployee(identifier);
        if (employee.isPresent()) {
            response = Response.ok().entity(employee.get()).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @GET
    @Cache(maxAge = 600)
    public Response getEmployees() {
        Response response;

        Set<Employee> employees = employeeService.getEmployees();
        if (employees.isEmpty()) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(employees).build();
        }

        return response;
    }
}
