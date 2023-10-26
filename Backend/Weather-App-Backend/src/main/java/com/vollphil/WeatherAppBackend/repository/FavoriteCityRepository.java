package com.vollphil.WeatherAppBackend.repository;

import com.vollphil.WeatherAppBackend.data.FavoriteCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteCityRepository extends JpaRepository<FavoriteCity,Long> {
}
