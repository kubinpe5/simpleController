package com.example.simplecontroller.service;

import com.example.simplecontroller.domain.Feedback;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FeedbackServiceTest {

    @Test
    void process() {
        final FeedbackService feedbackService = new FeedbackService();
        final Timestamp time = Timestamp.from(Instant.now());
        feedbackService.process(time, "Good");
        final Feedback feedback = feedbackService.getForTimestamp(time);
        assertEquals("Good", feedback.getFeedback());
    }
}
