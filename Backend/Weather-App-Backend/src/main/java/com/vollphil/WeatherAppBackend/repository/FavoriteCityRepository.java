package com.vollphil.WeatherAppBackend.repository;

import com.vollphil.WeatherAppBackend.data.FavoriteCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteCityRepository extends JpaRepository<FavoriteCity,Long> {
}
