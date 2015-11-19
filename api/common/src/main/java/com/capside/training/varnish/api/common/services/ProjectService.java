package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.Project;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectService {
    private final static ProjectService singletonInstance = new ProjectService();

    public static ProjectService get() {
        return singletonInstance;
    }

    private ClientService clientService;
    private ContactService contactService;
    private EmployeeService employeeService;
    private DataCenterService dataCenterService;

    private Map<String, Project> projects = new HashMap<>();

    public ProjectService(ClientService clientService, ContactService contactService, EmployeeService employeeService, DataCenterService dataCenterService) {
        this.clientService = clientService;
        this.contactService = contactService;
        this.employeeService = employeeService;
        this.dataCenterService = dataCenterService;

        buildModel();
    }

    private void buildModel() {
        //GEC
        //Very bad practice, but I ain't got not time for the workshop to do proper error handling
        Project gec = new Project("GEC",
                clientService.getClient("gec").get(),
                employeeService.getEmployee("jlmanzanares").get(),
                employeeService.getEmployee("tdavin").get(),
                employeeService.getEmployee("rarribas").get(),
                employeeService.getEmployee("ecolomer").get(),
                Arrays.asList(contactService.getContact("mbonastre").get(),
                        contactService.getContact("jcatedra").get()),
                Arrays.asList(dataCenterService.getDataCenter("colt").get()));
        projects.put(gec.getName(), gec);

        //Mango
        Project mango = new Project("Mango",
                clientService.getClient("mango").get(),
                employeeService.getEmployee("jlmanzanares").get(),
                employeeService.getEmployee("tdavin").get(),
                employeeService.getEmployee("rarribas").get(),
                employeeService.getEmployee("hdcesario").get(),
                Arrays.asList(contactService.getContact("jcpallas").get(),
                        contactService.getContact("jpereta").get()),
                Arrays.asList(dataCenterService.getDataCenter("aws").get()));
        projects.put(mango.getName(), mango);

        //Deporvillage
        Project deporvillage = new Project("Mango",
                clientService.getClient("mango").get(),
                employeeService.getEmployee("jlmanzanares").get(),
                employeeService.getEmployee("tdavin").get(),
                employeeService.getEmployee("rarribas").get(),
                employeeService.getEmployee("hdcesario").get(),
                Arrays.asList(contactService.getContact("tdorado").get(),
                        contactService.getContact("xpladellorens").get()),
                Arrays.asList(dataCenterService.getDataCenter("aws").get()));
        projects.put(deporvillage.getName(), deporvillage);
    }

    public ProjectService() {
        this(ClientService.get(), ContactService.get(), EmployeeService.get(), DataCenterService.get());
    }

    public Optional<Project> getProject(String name) {
        return Optional.ofNullable(projects.get(name));
    }

    public Set<Project> getProjects() {
        return projects.values().parallelStream().collect(Collectors.toSet());
    }
}
