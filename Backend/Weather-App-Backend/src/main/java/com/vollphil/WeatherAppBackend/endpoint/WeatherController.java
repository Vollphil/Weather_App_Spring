package com.vollphil.WeatherAppBackend.endpoint;

import com.vollphil.WeatherAppBackend.data.FavoriteCity;
import com.vollphil.WeatherAppBackend.data.LocationSuggestion;
import com.vollphil.WeatherAppBackend.data.WeatherData;
import com.vollphil.WeatherAppBackend.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    public final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/current/{location}")
    public WeatherData getCurrentWeather(@PathVariable String location){

        WeatherData data = weatherService.getWeatherForLocation(location);

        return data;
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/search/{query}")
    public List<LocationSuggestion> getCurrentAutoComplete(@PathVariable String query){
        List<LocationSuggestion> data = weatherService.getWeatherForLocationAutoComplete(query);
        return data;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/favoriteCity")
    public FavoriteCity saveFavoriteCity(@RequestBody FavoriteCity favoriteCity){
        return weatherService.saveFavoriteCity(favoriteCity);
    }
}
