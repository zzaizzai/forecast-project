package com.junsai.forecast_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
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

    public Forecast(String name, String unit, Double quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

}
