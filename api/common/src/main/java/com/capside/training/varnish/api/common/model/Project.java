package com.capside.training.varnish.api.common.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Project {
    private Employee sales;
    private Employee presales;
    private Employee SDM;
    private Employee engineer;

    private Set<Contact> contacts;
    private Set<DataCenter> dataCenters;
    private Client client;

    public Project(Client client,Employee sales, Employee presales, Employee SDM, Employee engineer, Collection<Contact> contacts, Collection<DataCenter> dataCenters) {
        this.client = client;
        this.sales = sales;
        this.presales = presales;
        this.SDM = SDM;
        this.engineer = engineer;
        this.contacts = contacts.parallelStream().collect(Collectors.toSet());
        this.dataCenters = dataCenters.parallelStream().collect(Collectors.toSet());
    }

    public Employee getSales() {
        return sales;
    }

    public void setSales(Employee sales) {
        this.sales = sales;
    }

    public Employee getPresales() {
        return presales;
    }

    public void setPresales(Employee presales) {
        this.presales = presales;
    }

    public Employee getSDM() {
        return SDM;
    }

    public void setSDM(Employee SDM) {
        this.SDM = SDM;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<DataCenter> getDataCenters() {
        return dataCenters;
    }

    public void setDataCenters(Set<DataCenter> dataCenters) {
        this.dataCenters = dataCenters;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEngineer() {
        return engineer;
    }

    public void setEngineer(Employee engineer) {
        this.engineer = engineer;
    }
}
