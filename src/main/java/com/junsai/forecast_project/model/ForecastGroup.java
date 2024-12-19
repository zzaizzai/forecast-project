package com.junsai.forecast_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "forecast_group")
public class ForecastGroup extends BaseEntity {

    public ForecastGroup(String name) {
        this.name = name;
    }

    public ForecastGroup(String name, String id) {
        this.name = name;
        this.id = id;
    }


}
