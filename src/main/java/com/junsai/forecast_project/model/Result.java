package com.junsai.forecast_project.model;

import com.junsai.forecast_project.util.DateTimeUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.text.DecimalFormat;

@Entity
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
