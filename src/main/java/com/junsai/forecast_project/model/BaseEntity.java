package com.junsai.forecast_project.model;

import com.junsai.forecast_project.util.DateTimeUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.text.DecimalFormat;
import java.util.Date;


@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    protected Date createdDate;

    @Column(name = "updated_date")
    @LastModifiedDate
    protected Date updatedDate;

    protected String unit;

    protected Double quantity;

    @Column(name = "deleted", nullable = false)
    protected boolean deleted = false;

    private String getFormattedDateTime(Double dateDouble) {

        String quantityStr = String.valueOf(dateDouble.longValue());

        String year = quantityStr.substring(0, 4);
        String month = quantityStr.substring(4, 6);
        String day = quantityStr.substring(6, 8);

        if (quantityStr.length() == 8) {
            return year + "-" + month + "-" + day;

        } else if (quantityStr.length() == 12) {
            String HH = quantityStr.substring(8, 10);
            String mm = quantityStr.substring(10, 12);
            return year + "-" + month + "-" + day + " " + HH + ":" + mm;

        } else {
            throw new IllegalArgumentException("Invalid quantity format: " + quantityStr);
        }
    }


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

    public String formattedCreatedDate() {
        return DateTimeUtil.formatDateTime(this.createdDate);
    }

    public String formattedUpdatedDate() {
        return DateTimeUtil.formatDateTime(this.updatedDate);
    }
}
