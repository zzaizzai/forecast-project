package com.junsai.forecast_project.repository;


import com.junsai.forecast_project.model.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    List<Forecast> findByDeleted(boolean deleted);

    @Query("SELECT f FROM Forecast f WHERE f.forecastGroup.id = :forecastGroupId")
    List<Forecast> findAllByForecastGroupId(String forecastGroupId);

}
