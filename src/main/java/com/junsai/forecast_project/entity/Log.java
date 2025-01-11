package com.junsai.forecast_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String ipAddress;
    @Setter
    private String methodName;
    private String logMessage;
    private LocalDateTime timestamp;

    public Log(String userName, String ipAddress, String methodName, String logMessage, LocalDateTime timestamp) {
        this.userName = userName;
        this.ipAddress = ipAddress;
        this.methodName = methodName;
        this.logMessage = logMessage;
        this.timestamp = timestamp;
    }

}