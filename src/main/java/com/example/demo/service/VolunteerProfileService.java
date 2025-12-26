package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileService {
    VolunteerProfile createProfile(VolunteerProfile profile);
    VolunteerProfile getProfileByVolunteerId(String volunteerId);
    List<VolunteerProfile> getAvailableVolunteers();
}
