package com.junsai.forecast_project.model;

import com.junsai.forecast_project.util.DateTimeUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.text.DecimalFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE results SET deleted = true where id = ?")
@Table(name = "results")
public class Result extends ForecastResultBaseEntity {

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

    public Result(Forecast forecast, String name, Double quantity) {
        this.forecast = forecast;
        this.unit = forecast.getUnit();
        this.name = name;
        this.quantity = quantity;
    }

    public Result(Forecast forecast, String name, int quantity) {
        this(forecast, name, (double) quantity);
    }

    public Result(Forecast forecast, String name, long quantity) {
        this(forecast, name, (double) quantity);
    }

    private Double getDiff() {
        return this.forecast.getQuantity() - this.getQuantity();
    }

    public String formattedDiff() {

        try {
            if (this.unit != null & this.unit.equals("Date")) {
                return DateTimeUtil.formattedDatetimeDiff(this.forecast.getQuantity(), this.getQuantity());
            }

            Double diffDouble = this.getDiff();
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##########");
            return decimalFormat.format(diffDouble);
        } catch (Exception e) {
            return "Error:" + e;
        }
    }

    public String getForecastGroupName() {
        return this.forecast.getForecastGroupName();
    }

    public Integer getForecastGroupId() {
        return this.forecast.getForecastGroupId();
    }

}
