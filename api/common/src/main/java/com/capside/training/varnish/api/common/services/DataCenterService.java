package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.DataCenter;

import java.util.*;
import java.util.stream.Collectors;

public class DataCenterService {

    private final static DataCenterService singletonInstance = new DataCenterService();
    public static DataCenterService get(){
        return singletonInstance;
    }

    private Map<String,DataCenter> dataCenters = new HashMap<>();

    public DataCenterService() {
        Arrays.asList(
            new DataCenter("claranet","ClaraNet, physical"),
            new DataCenter("azure","Azure, cloud"),
            new DataCenter("aws","Amazon Web Services, cloud"),
            new DataCenter("sw","Serveis Web, physical"),
            new DataCenter("colt","Colt, physical")
        ).parallelStream().forEach(datacenter->{dataCenters.put(datacenter.getName(),datacenter);});
    }

    public Optional<DataCenter> getDataCenter(String name){
        return Optional.ofNullable(dataCenters.get(name));
    }

    public Set<DataCenter> getDataCenters(){
        return dataCenters.values().parallelStream().collect(Collectors.toSet());
    }
}
