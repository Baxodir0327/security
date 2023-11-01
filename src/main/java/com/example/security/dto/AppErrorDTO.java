package com.example.security.dto;

import lombok.Data;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class AppErrorDTO {
    private String errorMessage;
    private String errorPath;
    private int errorCode;
    private LocalDateTime dateTime;

    public AppErrorDTO(String errorMessage, String errorPath, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorPath = errorPath;
        this.errorCode = errorCode;
        this.dateTime = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent")));
    }
}
