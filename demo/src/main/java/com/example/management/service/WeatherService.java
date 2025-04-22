package com.example.management.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {

    @Value("${weather.api.baseurl}")
    private String apiBaseUrl;


    private final RestTemplate restTemplate = new RestTemplate();

    public String getWeatherDetails(String cityName) {
        // Build the complete API URL with query params
        String url = String.format("%s?q=%s", apiBaseUrl, cityName);

        // Sending GET request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        return response.getBody(); // Returning the weather details as JSON
    }
}
