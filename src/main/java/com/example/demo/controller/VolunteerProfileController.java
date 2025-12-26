package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile createVolunteer(
            @RequestBody VolunteerProfile profile) {
        return service.createVolunteer(profile);
    }

    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return service.getAllVolunteers();
    }

    @GetMapping("/{id}")
    public VolunteerProfile getVolunteerById(
            @PathVariable Long id) {
        return service.getVolunteerById(id);
    }

    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateAvailability(id, status);
    }
}
