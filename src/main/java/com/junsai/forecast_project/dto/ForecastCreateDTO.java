package com.junsai.forecast_project.dto;

import com.junsai.forecast_project.model.ForecastGroup;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForecastCreateDTO {

    private long forecastGroupId;

    private String name;

    private String unit;

    private Double quantity;

    public ForecastCreateDTO() {
    }

    public ForecastCreateDTO(String name) {
        this.name = name;
    }

    public ForecastCreateDTO(ForecastGroup forecastGroup, String name, String unit, Double quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "forecastGroupID:" + this.forecastGroupId +
                "name:" + name +
                "unit:" + unit +
                "quantity" + quantity;
        
    }

}
