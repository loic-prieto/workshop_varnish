package com.capside.training.varnish.api.great.dtos;

import com.capside.training.varnish.api.common.model.Employee;
import com.capside.training.varnish.api.common.model.EmployeePosition;

public class EmployeeDTO extends BaseLanguageDTO {

    private String name;
    private String identifier;
    private EmployeePosition position;

    public EmployeeDTO(Employee employee,String language) {
        super(language);
        this.name = employee.getName();
        this.identifier = employee.getIdentifier();
        this.position = employee.getPosition();
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public EmployeePosition getPosition() {
        return position;
    }
}
