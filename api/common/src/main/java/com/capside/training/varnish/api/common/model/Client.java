package com.capside.training.varnish.api.common.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Client {
    private String name;
    private String description;
    private Set<Contact> contacts;

    public Client(String name, String description, Collection<Contact> contacts) {
        this.name = name;
        this.description = description;
        this.contacts = contacts.parallelStream().collect(Collectors.toSet());
    }

    public Client(String name, String description) {
        this(name,description,null);
    }

    public Client(String name) {
        this(name,null,null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!name.equals(client.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
