package com.differentdoors.openproject.services;

import com.differentdoors.openproject.models.OResults;
import com.differentdoors.openproject.models.Search.Filters;
import com.differentdoors.openproject.models.workpackage.WorkPackage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class WorkPackageService {
    @Value("${different_doors.open_project.url}")
    private String URL;


    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();

    @Autowired
    @Qualifier("OpenProject")
    private RestTemplate restTemplate;

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public OResults<WorkPackage> getWorkPackages(@Nullable Filters filter, @Nullable String pageSize) throws Exception {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "work_packages");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        if (filter != null) {
            urlParams.put("filter", objectMapper.writeValueAsString(filter.getFilters()));
            builder.queryParam("filter", "{filter}");
        }

        if (pageSize != null) {
            builder.queryParam("pageSize", pageSize);
        }

        return objectMapper.readValue(restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), String.class), new TypeReference<OResults<WorkPackage>>() {
        });
    }

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public WorkPackage getWorkPackage(String id) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "work_packages/" + id);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        return restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), WorkPackage.class);
    }

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public OResults<WorkPackage> getWorkPackagesByProject(String project, @Nullable Filters filter, @Nullable String pageSize) throws Exception {
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

        return objectMapper.readValue(restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), String.class), new TypeReference<OResults<WorkPackage>>() {
        });
    }

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public WorkPackage createWorkPackageInProject(String project, WorkPackage workPackage) throws Exception {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "projects/" + project + "/work_packages");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(objectMapper.writeValueAsString(workPackage), headers);

        return restTemplate.postForObject(builder.buildAndExpand(urlParams).toUri(), entity, WorkPackage.class);
    }

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public WorkPackage updateWorkPackage(String id, WorkPackage workPackage) throws Exception {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "work_packages/" + id);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(objectMapper.writeValueAsString(workPackage), headers);

        return restTemplate.patchForObject(builder.buildAndExpand(urlParams).toUri(), entity, WorkPackage.class);
    }

    @Recover
    public RetryException recover(Exception t){
        return new RetryException("Maximum retries reached: " + t.getMessage());
    }
}
