package com.junsai.forecast_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "results")
public class Result extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Forecast forecast;

    public Integer getForecastId() {
        return this.forecast.getId();
    }

    public String getForecastName() {
        return this.forecast.getName();
    }

    public String getForecastQuantity() {
        return this.forecast.formattedQuantity();
    }

    public String getForecastUnit() {
        return this.forecast.getUnit();
    }

    public Double getDiff() {
        return this.forecast.getQuantity() - this.getQuantity();
    }

}
