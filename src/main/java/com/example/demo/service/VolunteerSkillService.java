package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.List;

public interface VolunteerSkillRecordService {
    List<VolunteerSkillRecord> getSkillsByVolunteerId(String volunteerId);
}
