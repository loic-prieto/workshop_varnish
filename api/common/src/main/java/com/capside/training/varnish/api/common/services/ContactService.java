package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private static final ContactService singletonInstance = new ContactService();

    public static ContactService get() {
        return singletonInstance;
    }

    private Map<String, Contact> contacts = new HashMap<>();

    public ContactService() {

    }
}
