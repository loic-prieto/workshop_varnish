package com.capside.training.varnish.api.common.services;

import com.capside.training.varnish.api.common.model.Employee;
import com.capside.training.varnish.api.common.model.EmployeePosition;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    //Factory related
    private static EmployeeService singletonInstance = new EmployeeService();
    public static EmployeeService get(){
        return singletonInstance;
    }

    //Employee cache
    private Map<String,Employee> employees = new HashMap<String, Employee>();

    //Employee initialization
    public EmployeeService() {
        Arrays.asList(
            new Employee("ecolomer","Eleatzar Colomer",EmployeePosition.PROJECTS),
            new Employee("msoriano","Miquel Soriano",EmployeePosition.SUPPORT),
            new Employee("lprieto","Loïc Prieto",EmployeePosition.SUPPORT),
            new Employee("hdcesario","Daniel Cesario",EmployeePosition.PROJECTS),
            new Employee("jruano","Josep Ruano",EmployeePosition.CEO),
            new Employee("jlmartinez","José Luis Martinez",EmployeePosition.SUPPORT),
            new Employee("rarribas","Raúl Arribas",EmployeePosition.SDM),
            new Employee("jlmanzanares","Josep Lluis Manzanares",EmployeePosition.SALES),
            new Employee("tdavin","Thierry Davin",EmployeePosition.PRESALES)
        ).parallelStream().forEach(employee->{
            employees.put(employee.getIdentifier(),employee);
        });
    }

    public Optional<Employee> getEmployee(String identifier){
        return Optional.ofNullable(employees.get(identifier));
    }

    public Set<Employee> getEmployees() {
        return employees.values().parallelStream().collect(Collectors.toSet());
    }
}
