package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
    name = "volunteer_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    }
)
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String availabilityStatus;

    // ---------- Relationships ----------

    @OneToMany
    @JoinColumn(name = "volunteer_id")
    private List<VolunteerSkillRecord> skillRecords;

    @OneToMany
    @JoinColumn(name = "volunteer_id")
    private List<TaskAssignmentRecord> taskAssignments;

    // ---------- Constructors ----------

    public VolunteerProfile() {
    }

    public VolunteerProfile(String name, String email, String availabilityStatus) {
        this.name = name;
        this.email = email;
        this.availabilityStatus = availabilityStatus;
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
