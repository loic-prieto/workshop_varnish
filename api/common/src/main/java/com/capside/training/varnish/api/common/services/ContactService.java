package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.Contact;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ContactService {
    private static final ContactService singletonInstance = new ContactService();

    public static ContactService get() {
        return singletonInstance;
    }

    private Map<String, Contact> contacts = new HashMap<>();

    public ContactService() {
        Arrays.asList(
                new Contact("mbonastre", Arrays.asList("933941240", "933941240"), "mbonastrem@gec.es", "VIP"),
                new Contact("jcatedra", Arrays.asList("933941240", "933941240"), "jcatedra@gec.es", "VIP"),
                new Contact("jcpallas", Arrays.asList("610498524"), "joan.pallas@mango.com", "VIP"),
                new Contact("jpereta", Arrays.asList("610498208"), "jordi.pereta@mango.com", "VIP"),
                new Contact("tdorado", Arrays.asList("690095438"), "toni.dorado@deporvillage.com", "VIP"),
                new Contact("xpladellorens", Arrays.asList("677934194"), "xavier@deporvillage.com", "VIP")
        ).parallelStream().forEach(contact -> {
            contacts.put(contact.getName(), contact);
        });
    }

    public Contact getContact(String name) {
        return contacts.get(name);
    }

}
