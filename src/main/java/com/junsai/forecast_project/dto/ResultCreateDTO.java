package com.junsai.forecast_project.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultCreateDTO {

    @NotBlank(message = "Forecast ID is mandatory")
    private String forecastId;

    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @Size(min = 1, max = 20, message = "Unit must be between 1 and 20 characters")
    private String unit;

    @NotNull(message = "Quantity is mandatory")
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
