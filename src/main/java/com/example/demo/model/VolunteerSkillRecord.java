package com.example.demo.model;

import java.time.LocalDateTime;

public class VolunteerSkillRecord {

    private Long id;
    private String volunteerId;
    private String skillName;
    private String skillLevel;
    private LocalDateTime updatedAt;

    public VolunteerSkillRecord() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVolunteerId() { return volunteerId; }
    public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getSkillLevel() { return skillLevel; }
    public void setSkillLevel(String skillLevel) { this.skillLevel = skillLevel; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
