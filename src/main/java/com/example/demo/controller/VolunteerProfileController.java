package com.example.demo.controller;

import com.example.demo.dto.VolunteerProfileDTO;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfileDTO dto) {
        VolunteerProfile v = new VolunteerProfile();
        v.setVolunteerId(dto.getVolunteerId());
        v.setFullName(dto.getFullName());
        v.setEmail(dto.getEmail());
        v.setPhone(dto.getPhone());
        v.setAvailabilityStatus("AVAILABLE");
        return service.createVolunteer(v);
    }

    @GetMapping("/lookup/{vid}")
    public VolunteerProfile lookupByVolunteerId(@PathVariable String vid) {
        return service.findByVolunteerId(vid).orElse(null);
    }

    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAllVolunteers();
    }
}
