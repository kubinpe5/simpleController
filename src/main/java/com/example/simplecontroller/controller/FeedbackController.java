package com.example.simplecontroller.controller;

import com.example.simplecontroller.dto.FeedbackRequestDto;
import com.example.simplecontroller.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity<Object> processFeedback(@RequestBody FeedbackRequestDto request) {
        try {
            feedbackService.process(request.getTimestamp(), request.getFeedback());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
