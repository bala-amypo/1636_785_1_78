package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    VolunteerProfile findByVolunteerId(String volunteerId);
}
