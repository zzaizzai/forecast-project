package com.junsai.forecast_project.dto;

import com.junsai.forecast_project.model.ForecastGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForecastCreateDTO {

    @NotBlank(message = "Forecast Group ID is mandatory")
    private String forecastGroupId;

    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @Size(min = 1, max = 20, message = "Unit must be between 1 and 20 characters")
    private String unit;

    @NotBlank(message = "Quantity is mandatory")
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
