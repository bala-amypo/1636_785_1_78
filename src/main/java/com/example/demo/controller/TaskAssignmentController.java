package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;

@RestController
@RequestMapping("/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/task/{taskId}")
    public TaskAssignmentRecord assignTask(
            @PathVariable Long taskId) {
        return service.assignTask(taskId);
    }

    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateAssignmentStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateAssignmentStatus(id, status);
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getAssignmentsByTask(
            @PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getAssignmentsByVolunteer(volunteerId);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return service.getAllAssignments();
    }
}
