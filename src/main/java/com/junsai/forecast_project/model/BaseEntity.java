package com.junsai.forecast_project.model;

import com.junsai.forecast_project.util.DateTimeUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    public String formattedCreatedDate() {
        return DateTimeUtil.formatDateTime(this.createdDate);
    }

    public String formattedUpdatedDate() {
        return DateTimeUtil.formatDateTime(this.updatedDate);
    }
}
