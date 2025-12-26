package com.example.demo.model;

import java.time.LocalDateTime;

public class AssignmentEvaluationRecord {

    private Long id;
    private Long assignmentId;
    private int rating;
    private String feedback;
    private LocalDateTime evaluatedAt;

    public AssignmentEvaluationRecord() {
        this.evaluatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
}
