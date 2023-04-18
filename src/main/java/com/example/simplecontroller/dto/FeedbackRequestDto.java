package com.example.simplecontroller.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FeedbackRequestDto {

    private Timestamp timestamp;
    private String feedback;
}
