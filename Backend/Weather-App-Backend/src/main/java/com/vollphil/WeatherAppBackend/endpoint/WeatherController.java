package com.vollphil.WeatherAppBackend.endpoint;

import com.vollphil.WeatherAppBackend.data.LocationSuggestion;
import com.vollphil.WeatherAppBackend.data.WeatherData;
import com.vollphil.WeatherAppBackend.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    public final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public WeatherData getCurrentWeather(){

        WeatherData data = weatherService.getWeatherForLocation("london");

        return data;
    }

    @GetMapping("/search")
    public List<LocationSuggestion> getCurrentAutoComplete(){
        List<LocationSuggestion> data = weatherService.getWeatherForLocationAutoComplete("lon");
        return data;
    }
}
