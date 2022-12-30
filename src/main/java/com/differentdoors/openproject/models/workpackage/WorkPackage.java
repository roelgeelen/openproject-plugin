package com.differentdoors.openproject.models.workpackage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkPackage {
    private String id;
    private String subject;
    private String lockVersion;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    private Integer percentageDone;
    private Description description;
    private WorkPackage parent;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("customField5")
    private LocalDate montageDag;
    @JsonProperty("customField13")
    private String projectNr;
    @JsonProperty("customField15")
    private Integer montageTijd;
    @JsonProperty("customField27")
    private String weekNumber;
    @JsonProperty("customField28")
    private Boolean orderComplete;
    @JsonProperty("customField32")
    private Boolean ingemeten;
    @JsonProperty("customField33")
    private Boolean aanbetaling;
    @JsonProperty("customField39")
    private Integer weging;
    @JsonProperty("customField46")
    private Long debtorNumber;
    @JsonProperty("customField47")
    private String customerName;
    @JsonProperty("customField48")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("customField65")
    private LocalDate zetwerkBesteld;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("customField66")
    private LocalDate duwframeBesteld;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("customField67")
    private LocalDate dorpelBesteld;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("customField68")
    private LocalDate railsetBesteld;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("customField69")
    private LocalDate glasBesteld;
    @JsonProperty("customField70")
    private Description memo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("customField73")
    private LocalDate deurbeslagBesteld;
    @JsonProperty("customField75")
    private String adviseur;
    @JsonProperty("customField76")
    private Boolean gepland;
    @JsonProperty("customField79")
    private String deurGewichtExcl;
    @JsonProperty("customField80")
    private String deurGewichtIncl;
    @JsonProperty("customField82")
    private Description overigeOpmerkingen;

    @JsonProperty("_links")
    private Links links;
}


