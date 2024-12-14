package com.junsai.forecast_project.repository;


import com.junsai.forecast_project.model.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    List<Forecast> findByDeleted(boolean deleted);


}
