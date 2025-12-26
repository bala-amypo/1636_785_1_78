package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.VolunteerSkillRecord;

@Repository
public interface VolunteerSkillRecordRepository
        extends JpaRepository<VolunteerSkillRecord, Long> {

    List<VolunteerSkillRecord> findByVolunteerId(Long volunteerId);

    List<VolunteerSkillRecord> findBySkillName(String skillName);

    List<VolunteerSkillRecord> findBySkillNameAndSkillLevel(
            String skillName,
            String skillLevel);
}
