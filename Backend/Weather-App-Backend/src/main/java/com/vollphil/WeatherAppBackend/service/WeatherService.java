package com.vollphil.WeatherAppBackend.service;

import com.vollphil.WeatherAppBackend.api.WeatherAPIClient;
import com.vollphil.WeatherAppBackend.data.FavoriteCity;
import com.vollphil.WeatherAppBackend.data.LocationSuggestion;
import com.vollphil.WeatherAppBackend.data.WeatherData;
import com.vollphil.WeatherAppBackend.repository.FavoriteCityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherAPIClient apiClient;
    private final FavoriteCityRepository favoriteCityRepository;

    public WeatherService(WeatherAPIClient apiClient, FavoriteCityRepository favoriteCityRepository) {
        this.apiClient = apiClient;
        this.favoriteCityRepository = favoriteCityRepository;
    }
    public WeatherData getWeatherForLocation(String location) {
        return apiClient.getCurrentWeather(location);
    }

    public List<LocationSuggestion> getWeatherForLocationAutoComplete(String query){
        return apiClient.searchLocations(query);
    }

    public FavoriteCity saveFavoriteCity(FavoriteCity favoriteCity){
        return favoriteCityRepository.save(favoriteCity);
    }

    public void deleteCityById(Long id){
        favoriteCityRepository.deleteById(id);
    }
}
