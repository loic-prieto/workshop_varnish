package com.capside.training.varnish.api.common.model;

import java.util.Set;

public class Project {
    private Employee sales;
    private Employee presales;
    private Employee SDM;

    private Set<Contact> contacts;
    private Set<DataCenter> dataCenters;
    private Client client;

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
}
