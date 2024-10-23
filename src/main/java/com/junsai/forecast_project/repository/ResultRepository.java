package com.junsai.forecast_project.repository;

import com.junsai.forecast_project.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByDeleted(boolean deleted);
}
