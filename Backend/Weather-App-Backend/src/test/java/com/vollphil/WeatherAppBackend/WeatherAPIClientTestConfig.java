    package com.vollphil.WeatherAppBackend;

    import com.vollphil.WeatherAppBackend.api.WeatherAPIClient;
    import org.mockito.Mockito;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.client.RestTemplate;
    @Configuration
    public class WeatherAPIClientTestConfig {
        @Bean
        public RestTemplate restTemplate() {
            return Mockito.mock(RestTemplate.class);
        }
        @Bean
        public WeatherAPIClient weatherAPIClient(@Value("${weatherapi.key}") String apiKey, RestTemplate restTemplate) {
            return new WeatherAPIClient(apiKey, restTemplate);
        }
    }
