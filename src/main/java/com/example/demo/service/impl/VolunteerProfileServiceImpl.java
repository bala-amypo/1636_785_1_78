package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

@Service
public class VolunteerProfileServiceImpl
        implements VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {

        if (repo.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        if (repo.existsByVolunteerId(profile.getVolunteerId())) {
            throw new BadRequestException("Volunteer ID already exists");
        }
        if (repo.existsByPhone(profile.getPhone())) {
            throw new BadRequestException("Phone already exists");
        }

        return repo.save(profile);
    }


    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Volunteer not found"));
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repo.findAll();
    }

    @Override
    public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String status) {
        VolunteerProfile v = getVolunteerById(id);
        v.setAvailabilityStatus(status);
        return repo.save(v);
    }
}
