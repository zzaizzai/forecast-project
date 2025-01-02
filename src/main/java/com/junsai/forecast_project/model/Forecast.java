package com.junsai.forecast_project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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

    // JsonManagedReference: prevent circular reference
    @OneToMany(mappedBy = "forecast", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Result> results = new ArrayList<>();

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

    public Result getLastResult() {
        if (this.results.isEmpty()) {
            return null;
        }
        return this.results.get(this.results.size() - 1);
    }

    public String formattedDiff() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##########");
        return decimalFormat.format(this.getDiff());
    }

    protected Double getDiff() {
        if (this.getLastResult() == null) {
            return 0.0;
        } else {
            return this.getQuantity() - this.getLastResult().getQuantity();
        }
    }
    
    public void softDelete() {
        this.setDeleted(true);
    }

}
