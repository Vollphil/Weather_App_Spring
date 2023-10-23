package com.vollphil.WeatherAppBackend;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherAPIClient apiClient;

    public WeatherService(WeatherAPIClient apiClient) {
        this.apiClient = apiClient;
    }
    public WeatherData getWeatherForLocation(String location) {
        return apiClient.getCurrentWeather(location);
    }
}
