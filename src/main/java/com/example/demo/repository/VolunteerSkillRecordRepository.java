package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.VolunteerSkillRecord;
import java.util.List;

public interface VolunteerSkillRecordRepository
        extends JpaRepository<VolunteerSkillRecord, Long> {

    List<VolunteerSkillRecord> findByVolunteerId(Long volunteerId);
}
