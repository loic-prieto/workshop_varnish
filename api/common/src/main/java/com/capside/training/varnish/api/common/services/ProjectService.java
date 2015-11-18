package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectService {
    private final static ProjectService singletonInstance = new ProjectService();

    public static ProjectService get() {
        return singletonInstance;
    }


    private Map<String, Project> projects = new HashMap<>();

    /*public ProjectService() {
        Project gec = new Project()
    }

    public Optional<DataCenter> getDataCenter(String name){
        return Optional.ofNullable(dataCenters.get(name));
    }

    public Set<DataCenter> getDataCenters(){
        return dataCenters.values().parallelStream().collect(Collectors.toSet());
    }*/
}
