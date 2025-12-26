package com.example.demo.model;

public class TaskAssignmentRecord {

    private Long id;
    private Long taskId;
    private String volunteerId;
    private String status;

    public TaskAssignmentRecord() {
        this.status = "ACTIVE";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }

    public String getVolunteerId() { return volunteerId; }
    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
