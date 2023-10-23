package com.vollphil.WeatherAppBackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherAPIClient {
    private final String API_URL =  "http://api.weatherapi.com/v1";
    private final String apiKey;

    public WeatherAPIClient(@Value("${weatherapi.key}")String apiKey) {
        this.apiKey = apiKey;
    }
}
