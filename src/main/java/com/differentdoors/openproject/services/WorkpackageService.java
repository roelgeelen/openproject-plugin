package com.differentdoors.openproject.services;

import com.differentdoors.openproject.models.OResults;
import com.differentdoors.openproject.models.Search.Filter;
import com.differentdoors.openproject.models.Search.Filters;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkpackageService {
    @Value("${differentdoors.openproject.url}")
    private String URL;


    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();

    @Autowired
    @Qualifier("OpenProject")
    private RestTemplate restTemplate;

    public OResults getWorkpackages(String project, @Nullable Filters filter, @Nullable String pageSize) throws JsonProcessingException {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "projects/" + project + "/work_packages");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        if (filter != null) {
            urlParams.put("filter", objectMapper.writeValueAsString(filter.getFilters()));
            builder.queryParam("filter", "{filter}");
        }

        if (pageSize != null) {
            builder.queryParam("pageSize", pageSize);
        }

        return objectMapper.readValue(restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), String.class), OResults.class);
    }
}
