package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.demo.entity.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;

@RestController
@RequestMapping("/volunteer")
public class VolunteerProfileController {

    @Autowired
    VolunteerProfileService service;

    @PostMapping("/post")
    public VolunteerProfile post(@RequestBody VolunteerProfile v) {
        return service.postData(v);
    }

    @GetMapping("/get/{id}")
    public VolunteerProfile get(@PathVariable Long id) {
        return service.getData(id);
    }

    @GetMapping("/all")
    public List<VolunteerProfile> all() {
        return service.getAll();
    }
}
