package com.junsai.forecast_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    protected  Integer  id;

    private String name;
    private String email;
}
