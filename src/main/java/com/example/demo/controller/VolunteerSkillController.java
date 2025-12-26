package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;

@RestController
@RequestMapping("/skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerSkillRecord addOrUpdateSkill(
            @RequestBody VolunteerSkillRecord skill) {
        return service.addOrUpdateSkill(skill);
    }

    @GetMapping
    public List<VolunteerSkillRecord> getAllSkills() {
        return service.getAllSkills();
    }

    @GetMapping("/{id}")
    public VolunteerSkillRecord getSkillById(
            @PathVariable Long id) {
        return service.getSkillById(id);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getSkillsByVolunteer(volunteerId);
    }
}
