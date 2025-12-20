package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile registerVolunteer(
            @RequestBody RegisterRequest request) {
        return service.registerVolunteer(request);
    }

    @PatchMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestBody AvailabilityUpdateRequest request) {
        return service.updateAvailability(id, request.getAvailabilityStatus());
    }

    @GetMapping("/available")
    public List<VolunteerProfile> getAvailableVolunteers() {
        return service.getAvailableVolunteers();
    }
}
