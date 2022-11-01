package com.differentdoors.openproject.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigurationOpenProject {
    @Value("${differentdoors.openproject.user}")
    private String user;

    @Value("${differentdoors.openproject.apikey}")
    private String apikey;

    @Bean(name = "OpenProject")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(15000);
        requestFactory.setReadTimeout(15000);
        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
        requestFactory.setHttpClient(httpClient);
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("apikey", "bed7462011a419a9648aec81425985dc88f0381a9f3d02d222604cf0c5a34531"));

        return restTemplate;
    }
}
