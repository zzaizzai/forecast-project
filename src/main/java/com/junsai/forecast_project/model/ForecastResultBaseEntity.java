package com.junsai.forecast_project.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public abstract class ForecastResultBaseEntity extends BaseEntity {

    protected String unit;

    protected Double quantity;


    public String formattedQuantity() {

        try {
            //        show as 2024-12-12
            if (this.unit != null & this.unit.equals("Date")) {
                return this.getFormattedDateTime(this.quantity);
            }
            //        show as 2024-12-12 12:12
            if (this.unit != null & this.unit.equals("Datetime")) {
                return this.getFormattedDateTime(this.quantity);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

//        show as 1,000,000 or 1.123
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##########");
        return decimalFormat.format(this.quantity);
    }


}
