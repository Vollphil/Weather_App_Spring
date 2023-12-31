package com.vollphil.WeatherAppBackend.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteCity {
    @Id
    @GeneratedValue
    private Long  id;

    private String cityName;
    private String countryName;

}
