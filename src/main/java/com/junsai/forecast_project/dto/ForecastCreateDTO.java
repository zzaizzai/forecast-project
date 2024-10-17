package com.junsai.forecast_project.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForecastCreateDTO {

    private String name;

    public ForecastCreateDTO() {
    }
    public ForecastCreateDTO(String name) {
        this.name = name;
    }

}
