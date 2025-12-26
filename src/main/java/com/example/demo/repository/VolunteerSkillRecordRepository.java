package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.VolunteerSkillRecord;

public interface VolunteerSkillRecordRepository {
    List<VolunteerSkillRecord> findByVolunteerId(String volunteerId);
}
