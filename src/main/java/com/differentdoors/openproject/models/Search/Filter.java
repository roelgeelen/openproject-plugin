package com.differentdoors.openproject.models.Search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Filter {
    private String operator;
    private String value;
    private List<String> values;

    public Filter(String operator, String value) {
        this.operator = operator;
        this.value = value;
    }

    public Filter(String operator, List<String> values) {
        this.operator = operator;
        this.values = values;
    }
}
