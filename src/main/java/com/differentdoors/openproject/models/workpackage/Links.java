package com.differentdoors.openproject.models.workpackage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    private Href type;
    private Href status;

    public Href getType() {
        return type;
    }

    public Href getStatus() {
        return status;
    }
}
