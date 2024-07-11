package com.differentdoors.openproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfigurationOpenProject {
    @Value("${different_doors.open_project.user}")
    private String user;

    @Value("${different_doors.open_project.apikey}")
    private String apikey;

    @Bean(name = "OpenProject")
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(15))
                .setReadTimeout(Duration.ofSeconds(15))
                .basicAuthentication(user, apikey).build();
    }
}
