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

    
}
