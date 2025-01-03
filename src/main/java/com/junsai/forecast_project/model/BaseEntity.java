package com.junsai.forecast_project.model;

import com.junsai.forecast_project.util.DateTimeUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;


@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @Column(name = "id", nullable = true)
    protected String id;

    @PrePersist
    public void prePersistSetId() {
        if (this.id == null || this.id.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHH");
            this.id = LocalDateTime.now().format(formatter) + UUID.randomUUID().toString().substring(0, 4);
        }
    }

    protected String name;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    protected Date createdDate;

    @Column(name = "updated_date")
    @LastModifiedDate
    protected Date updatedDate;


    @Column(name = "deleted", nullable = false)
    protected boolean deleted = false;

    protected String getFormattedDateTime(Double dateDouble) {

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


    public String formattedCreatedDate() {
        return DateTimeUtil.formatDateTime(this.createdDate);
    }

    public String formattedUpdatedDate() {
        return DateTimeUtil.formatDateTime(this.updatedDate);
    }
}
