package com.junsai.forecast_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE forecasts SET deleted = true where id = ?")
@Table(name = "forecasts")
public class Forecast extends ForecastResultBaseEntity {

    @ManyToOne
    @JoinColumn(name = "forecast_group_id", nullable = false)
    private ForecastGroup forecastGroup;

    public Forecast(ForecastGroup forecastGroup, String name, String unit, Double quantity) {
        this.forecastGroup = forecastGroup;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Forecast(ForecastGroup forecastGroup, String name, String unit, int quantity) {
        this(forecastGroup, name, unit, (double) quantity);
    }

    public Forecast(ForecastGroup forecastGroup, String name, String unit, long quantity) {
        this(forecastGroup, name, unit, (double) quantity);
    }

    public String getForecastGroupName() {
        return this.forecastGroup.getName();
    }

    public String getForecastGroupId() {
        return this.forecastGroup.getId();
    }

}
