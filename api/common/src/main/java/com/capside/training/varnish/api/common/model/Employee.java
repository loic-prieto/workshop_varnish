package com.capside.training.varnish.api.common.model;

public class Employee {
    private String name;
    private String identifier;
    private EmployeePosition position;

    public Employee(String identifier,String name, EmployeePosition position) {
        this.identifier = identifier;
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!identifier.equals(employee.identifier)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
