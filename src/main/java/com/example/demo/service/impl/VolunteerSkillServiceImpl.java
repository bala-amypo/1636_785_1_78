package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
@Service
public class VolunteerSkillServiceImpl
        implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillServiceImpl(
            VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(
            VolunteerSkillRecord skill) {
        return repo.save(skill);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(
            Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    @Override
    public VolunteerSkillRecord getSkillById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Skill not found"));
    }

    @Override
    public List<VolunteerSkillRecord> getAllSkills() {
        return repo.findAll();
    }
}
