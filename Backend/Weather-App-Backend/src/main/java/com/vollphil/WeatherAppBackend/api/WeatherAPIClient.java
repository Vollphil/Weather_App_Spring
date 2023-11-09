package com.vollphil.WeatherAppBackend.api;

import com.vollphil.WeatherAppBackend.data.LocationSuggestion;
import com.vollphil.WeatherAppBackend.data.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherAPIClient {
    private final String API_URL =  "http://api.weatherapi.com/v1";
    private final String apiKey;
    private final RestTemplate restTemplate;

    public WeatherAPIClient(@Value("${weatherapi.key}")String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public WeatherData getCurrentWeather(String location) {
        String requestUrl = API_URL + "/current.json?key=" + apiKey + "&q=" + location;

        ResponseEntity<WeatherData> response = restTemplate.getForEntity(requestUrl, WeatherData.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {

            throw new RuntimeException("Failed to fetch weather data. Status code: " + response.getStatusCode());
        }
    }

    public List<LocationSuggestion> searchLocations(String query){
        String requestUrl = API_URL + "/search.json?key=" + apiKey + "&q=" + query;
        ResponseEntity<List<LocationSuggestion>> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch location suggestions. Status code: " + response.getStatusCode());
        }
    }
}
