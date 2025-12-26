package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface VolunteerProfileRepository {
    boolean existsByVolunteerId(String volunteerId);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);
    List<VolunteerProfile> findByAvailabilityStatus(String status);
}
