package com.capside.training.varnish.api.great.dtos;

import com.capside.training.varnish.api.common.model.Client;

import java.util.HashSet;
import java.util.Set;

public class ClientDTO extends BaseLanguageDTO {
    private String name;
    private String description;
    private Set<ContactDTO> contacts = new HashSet<>();

    public ClientDTO(Client client, String language) {
        super(language);
        this.name = client.getName();
        this.description = client.getDescription();
        client.getContacts().forEach(contact -> {
            contacts.add(new ContactDTO(contact, language));
        });
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<ContactDTO> getContacts() {
        return contacts;
    }
}
