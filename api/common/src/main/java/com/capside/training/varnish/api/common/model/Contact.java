package com.capside.training.varnish.api.common.model;

import java.util.Set;

public class Contact {
    private String name;
    private Set<String> telephones;
    private String email;
    private String observations;

    public Contact(String name, Set<String> telephones, String email, String observations) {
        this.name = name;
        this.telephones = telephones;
        this.email = email;
        this.observations = observations;
    }

    public Contact(String name, String email, String observations) {
        this.name = name;
        this.email = email;
        this.observations = observations;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Set<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<String> telephones) {
        this.telephones = telephones;
    }
}
