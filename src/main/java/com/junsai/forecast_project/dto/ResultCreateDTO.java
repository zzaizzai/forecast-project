package com.junsai.forecast_project.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultCreateDTO {

    private String forecastId;

    private String name;

    private String unit;

    private Double quantity;

    public ResultCreateDTO() {
    }

    public ResultCreateDTO(String name) {
        this.name = name;
    }

    public ResultCreateDTO(String forecastId, String name, String unit, Double quantity) {
        this.forecastId = forecastId;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "forecastId:" + this.forecastId +
                "name:" + name +
                "unit:" + unit +
                "quantity" + quantity;

    }
}
