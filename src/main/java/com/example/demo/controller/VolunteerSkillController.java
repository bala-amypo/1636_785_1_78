package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillController {

    @Autowired
    VolunteerSkillService service;

    // POST /api/skills
    @PostMapping
    public VolunteerSkillRecord addOrUpdate(@RequestBody VolunteerSkillRecord skill) {
        return service.addOrUpdateSkill(skill);
    }

    // GET /api/skills/volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getByVolunteer(@PathVariable Long volunteerId) {
        return service.getSkillsByVolunteer(volunteerId);
    }

    // GET /api/skills/{id}
    @GetMapping("/{id}")
    public VolunteerSkillRecord getById(@PathVariable Long id) {
        return service.getSkillById(id);
    }

    // GET /api/skills
    @GetMapping
    public List<VolunteerSkillRecord> getAll() {
        return service.getAllSkills();
    }
}
