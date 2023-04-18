package com.example.simplecontroller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FeedbackDto {

    private LocalDateTime date;
    private String feedback;
}
