package com.vollphil.WeatherAppBackend.service;

import com.vollphil.WeatherAppBackend.api.WeatherAPIClient;
import com.vollphil.WeatherAppBackend.data.LocationSuggestion;
import com.vollphil.WeatherAppBackend.data.WeatherData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherAPIClient apiClient;

    public WeatherService(WeatherAPIClient apiClient) {
        this.apiClient = apiClient;
    }
    public WeatherData getWeatherForLocation(String location) {
        return apiClient.getCurrentWeather(location);
    }

    public List<LocationSuggestion> getWeatherForLocationAutoComplete(String query){
        return apiClient.searchLocations(query);
    }


}
