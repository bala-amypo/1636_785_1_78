package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.demo.entity.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    @Autowired
    VolunteerProfileRepository repo;

    public VolunteerProfile postData(VolunteerProfile v) {
        return repo.save(v);
    }

    public VolunteerProfile getData(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<VolunteerProfile> getAll() {
        return repo.findAll();
    }
}
