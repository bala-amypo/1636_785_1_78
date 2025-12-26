package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TaskAssignmentRecord;

public interface TaskAssignmentService {

    TaskAssignmentRecord assignTask(Long taskId);

    TaskAssignmentRecord updateAssignmentStatus(Long id, String status);

    List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);

    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);

    List<TaskAssignmentRecord> getAllAssignments();
}
