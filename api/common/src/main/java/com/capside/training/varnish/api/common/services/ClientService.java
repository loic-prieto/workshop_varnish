package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientService {

    private static final ClientService singletonInstance = new ClientService();
    public static ClientService get(){
        return singletonInstance;
    }

    Map<String,Client> clients = new HashMap<>();


    public ClientService() {
        new Client("TMB","TMB");
    }





}
