package com.differentdoors.openproject.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
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
    private RestTemplate restTemplate;

    public String getWorkpackages(String project, @Nullable String filter) throws JsonProcessingException {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "projects/" + project + "/work_packages");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        if (filter != null) {
            builder.queryParam("filter", filter);
        }

        return restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), String.class);
    }
}
