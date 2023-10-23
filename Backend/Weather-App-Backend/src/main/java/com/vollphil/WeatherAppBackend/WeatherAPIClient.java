package com.vollphil.WeatherAppBackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherAPIClient {
    private final String API_URL =  "http://api.weatherapi.com/v1";
    private final String apiKey;
    private final RestTemplate restTemplate;

    public WeatherAPIClient(@Value("${weatherapi.key}")String apiKey) {
        this.apiKey = apiKey;
        this.restTemplate = new RestTemplate();
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
}
