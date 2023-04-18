package com.example.simplecontroller.domain;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Feedback {

    private Long userId;
    private Timestamp timestamp;
    private String feedback;
}
