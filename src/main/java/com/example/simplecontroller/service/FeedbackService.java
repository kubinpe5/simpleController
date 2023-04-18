package com.example.simplecontroller.service;

import com.example.simplecontroller.domain.Feedback;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class FeedbackService {

    // Mock of repository
    private final Map<Timestamp, Feedback> feedbacks = new HashMap<>();

    public void process(final Timestamp timestamp, final String feedback) {
        final Feedback existingFeedback = feedbacks.get(timestamp);
        if (existingFeedback != null) {
            if (existingFeedback.getTimestamp().compareTo(timestamp) >= 0) {
                // older feedback, do not save it
                return;
            } else {
                existingFeedback.setFeedback(feedback);
            }
        }
        feedbacks.put(timestamp, Feedback.builder().feedback(feedback).timestamp(timestamp).build());
    }

    public Feedback getForTimestamp(final Timestamp timestamp) {
        return feedbacks.get(timestamp);
    }
}
