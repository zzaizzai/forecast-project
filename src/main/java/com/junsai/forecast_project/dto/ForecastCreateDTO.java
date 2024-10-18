package com.junsai.forecast_project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForecastCreateDTO {

    private String name;

    private String unit;

    private Double quantity;

    public ForecastCreateDTO() {
    }

    public ForecastCreateDTO(String name) {
        this.name = name;
    }

    public ForecastCreateDTO(String name, String unit, Double quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }
}
