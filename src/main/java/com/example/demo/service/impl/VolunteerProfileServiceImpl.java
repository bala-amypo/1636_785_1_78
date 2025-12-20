package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile registerVolunteer(RegisterRequest request) {

        if (request.getName() == null || request.getEmail() == null) {
            throw new BadRequestException("Name and Email are required");
        }

        repository.findByEmail(request.getEmail()).ifPresent(v -> {
            throw new BadRequestException("Email already exists");
        });

        String status = request.getAvailabilityStatus();
        if (!isValidStatus(status)) {
            throw new BadRequestException("Invalid availability status");
        }

        VolunteerProfile volunteer = new VolunteerProfile(
                request.getName(),
                request.getEmail(),
                status
        );

        return repository.save(volunteer);
    }

    @Override
    public VolunteerProfile updateAvailability(Long volunteerId, String availabilityStatus) {

        if (!isValidStatus(availabilityStatus)) {
            throw new BadRequestException("Invalid availability status");
        }

        VolunteerProfile volunteer = repository.findById(volunteerId)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));

        volunteer.setAvailabilityStatus(availabilityStatus);
        return repository.save(volunteer);
    }

    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return repository.findByAvailabilityStatus("AVAILABLE");
    }

    private boolean isValidStatus(String status) {
        return "AVAILABLE".equalsIgnoreCase(status)
                || "UNAVAILABLE".equalsIgnoreCase(status);
    }
}
