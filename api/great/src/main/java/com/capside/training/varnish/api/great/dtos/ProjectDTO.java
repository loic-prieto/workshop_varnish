package com.capside.training.varnish.api.great.dtos;

import com.capside.training.varnish.api.common.model.*;

import java.util.HashSet;
import java.util.Set;

public class ProjectDTO extends BaseLanguageDTO {

    private EmployeeDTO sales;
    private EmployeeDTO presales;
    private EmployeeDTO SDM;
    private EmployeeDTO engineer;

    private Set<ContactDTO> contacts = new HashSet<>();
    private Set<DataCenterDTO> dataCenters = new HashSet<>();
    private ClientDTO client;

    private String name;

    public ProjectDTO(Project project,String language) {
        super(language);
        this.name = project.getName();
        this.sales = new EmployeeDTO(project.getSales(),language);
        this.presales = new EmployeeDTO(project.getPresales(),language);
        this.SDM = new EmployeeDTO(project.getSDM(),language);
        this.engineer = new EmployeeDTO(project.getEngineer(),language);
        this.client = new ClientDTO(project.getClient(),language);
        project.getContacts().forEach(contact->{
            this.contacts.add(new ContactDTO(contact,language));
        });
        project.getDataCenters().forEach(dataCenter->{
            this.dataCenters.add(new DataCenterDTO(dataCenter,language));
        });
    }

    public EmployeeDTO getSales() {
        return sales;
    }

    public EmployeeDTO getPresales() {
        return presales;
    }

    public EmployeeDTO getSDM() {
        return SDM;
    }

    public EmployeeDTO getEngineer() {
        return engineer;
    }

    public Set<ContactDTO> getContacts() {
        return contacts;
    }

    public Set<DataCenterDTO> getDataCenters() {
        return dataCenters;
    }

    public ClientDTO getClient() {
        return client;
    }

    public String getName() {
        return name;
    }
}
