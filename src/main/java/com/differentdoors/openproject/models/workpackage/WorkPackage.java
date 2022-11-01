package com.differentdoors.openproject.models.workpackage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkPackage {
    private String id;
    //week number
    private String customField27;
    //order compleet
    private boolean customField28;
    //is ingemeten
    private boolean customField32;
    //weging
    private int customField39;

    private String dueDate;

    @JsonProperty("percentageDone")
    private String percentageDone;
    @JsonProperty("_links")
    private Links links;

    public String getId() {
        return id;
    }

    public Links getLinks() {
        return this.links;
    }

    public String getCustomField27() {
        return customField27;
    }

    public boolean getCustomField28() {
        return customField28;
    }

    public boolean isCustomField32() {
        return customField32;
    }

    public int getCustomField39() {
        return customField39;
    }

    public String getDueDate() {
        return dueDate;
    }
}


