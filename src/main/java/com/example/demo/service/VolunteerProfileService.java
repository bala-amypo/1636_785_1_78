package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VolunteerProfile;

public interface VolunteerProfileService {
    VolunteerProfile postData(VolunteerProfile v);
    VolunteerProfile getData(Long id);
    List<VolunteerProfile> getAll();
}
