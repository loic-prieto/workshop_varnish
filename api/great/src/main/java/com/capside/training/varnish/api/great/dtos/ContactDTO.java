package com.capside.training.varnish.api.great.dtos;

import com.capside.training.varnish.api.common.model.Contact;

import java.util.Set;

public class ContactDTO extends BaseLanguageDTO{
    private String name;
    private Set<String> telephones;
    private String email;
    private String observations;

    public ContactDTO(Contact contact,String language) {
        super(language);
        this.name = contact.getName();
        this.telephones = contact.getTelephones();
        this.email = contact.getEmail();
        this.observations = contact.getObservations();
    }

    public String getName() {
        return name;
    }

    public Set<String> getTelephones() {
        return telephones;
    }

    public String getEmail() {
        return email;
    }

    public String getObservations() {
        return observations;
    }
}
