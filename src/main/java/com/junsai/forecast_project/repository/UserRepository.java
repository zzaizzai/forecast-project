package com.junsai.forecast_project.repository;

import com.junsai.forecast_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
