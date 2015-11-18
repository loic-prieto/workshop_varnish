package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.Client;
import com.capside.training.varnish.api.common.model.Contact;

import java.util.*;
import java.util.stream.Collectors;

public class ClientService {

    private static final ClientService singletonInstance = new ClientService();
    public static ClientService get(){
        return singletonInstance;
    }

    private ContactService contactService;

    private Map<String,Client> clients = new HashMap<>();

    public ClientService(){
        this(ContactService.get());
    }

    public ClientService(ContactService contactService) {
        this.contactService = contactService;

        //Build up the client list with contacts
        List<Client> clientList = new ArrayList<Client>();
        Contact bonastre = this.contactService.getContact("mbonastre");
        Contact catedra = this.contactService.getContact("jcatedra");
        clientList.add(new Client("gec","GEC Learning Services", Arrays.asList(bonastre,catedra)));
        Contact joanpallas = this.contactService.getContact("jcpallas");
        Contact pereta = this.contactService.getContact("jpereta");
        clientList.add(new Client("mango","Mango Shop", Arrays.asList(joanpallas,pereta)));
        Contact tonidorado = this.contactService.getContact("tdorado");
        Contact xpladellorens = this.contactService.getContact("xpladellorens");
        clientList.add(new Client("deporvillage","Deporvillage", Arrays.asList(tonidorado,xpladellorens)));

        clientList.parallelStream().forEach(client->{
            clients.put(client.getName(),client);
        });
    }

    public Optional<Client> getClient(String name){
        return Optional.ofNullable(clients.get(name));
    }

    public Set<Client> getClients(){
        return clients.values().parallelStream().collect(Collectors.toSet());
    }
}
