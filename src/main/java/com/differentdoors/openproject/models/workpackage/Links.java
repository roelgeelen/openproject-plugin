package com.differentdoors.openproject.models.workpackage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    private Href type;
    private Href status;
    private Href parent;
    private Href assignee;
    private List<Href> children;

    @JsonProperty("customField2")
    private Href railset;
    @JsonProperty("customField3")
    private List<Href> zetwerk;
    @JsonProperty("customField10")
    private Href aangeleverd;
    @JsonProperty("customField17")
    private List<Href> deurbeslag;
    @JsonProperty("customField22")
    private List<Href> dorpel;
    @JsonProperty("customField23")
    private Href glas;
    @JsonProperty("customField30")
    private List<Href> montageTeam;
    @JsonProperty("customField49")
    private List<Href> duwframe;
    @JsonProperty("customField78")
    private Href typeMotor;
    @JsonProperty("customField92")
    private Href vingerknel;
    @JsonProperty("customField97")
    private Href resthout;
}
