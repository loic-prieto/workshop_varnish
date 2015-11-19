package com.capside.training.varnish.api.great.dtos;

import com.capside.training.varnish.api.common.model.DataCenter;

public class DataCenterDTO extends BaseLanguageDTO {
    private String name;
    private String description;

    public DataCenterDTO(DataCenter dataCenter,String language) {
        super(language);
        this.name = dataCenter.getName();
        this.description = dataCenter.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
