package com.junsai.forecast_project.repository;

import com.junsai.forecast_project.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, String> {
    List<Result> findByDeleted(boolean deleted);

    @Query("SELECT r FROM Result r WHERE r.forecast.id = :forecastId")
    List<Result> findAllByForecastId(@Param("forecastId") String forecastId);
}
