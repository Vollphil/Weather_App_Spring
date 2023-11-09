package com.vollphil.WeatherAppBackend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vollphil.WeatherAppBackend.api.WeatherAPIClient;
import com.vollphil.WeatherAppBackend.data.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(classes = WeatherAPIClientTestConfig.class)
@ActiveProfiles("test")
public class WeatherAPIClientTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherAPIClient weatherAPIClient;

    @Value("${weatherapi.key}")
    private String apiKey;

    @BeforeEach
    void setUp() {

    }

    @Test
    void whenGetWeatherDataIsCalled_thenClientMakesApiRequest() {

        String location = "London";
        String url = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location;
        WeatherData mockWeatherData = new WeatherData();
        ResponseEntity<WeatherData> mockResponse = new ResponseEntity<>(mockWeatherData, HttpStatus.OK);
        when(restTemplate.getForEntity(url, WeatherData.class)).thenReturn(mockResponse);


        WeatherData result = weatherAPIClient.getCurrentWeather(location);


        assertEquals(mockWeatherData, result);
        verify(restTemplate).getForEntity(url, WeatherData.class);
    }

    @Test
    void whenApiRequestFails_thenThrowException() {

        String location = "London";
        String url = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location;
        ResponseEntity<WeatherData> mockResponse = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        when(restTemplate.getForEntity(url, WeatherData.class)).thenReturn(mockResponse);


        Exception exception = assertThrows(RuntimeException.class, () -> {
            weatherAPIClient.getCurrentWeather(location);
        });


        assertTrue(exception.getMessage().contains("Failed to fetch weather data"));
    }
}
