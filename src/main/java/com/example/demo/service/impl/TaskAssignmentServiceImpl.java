package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskAssignmentService;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository repo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volunteerRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository repo,
            TaskRecordRepository taskRepo,
            VolunteerProfileRepository volunteerRepo,
            VolunteerSkillRecordRepository skillRepo) {
        this.repo = repo;
        this.taskRepo = taskRepo;
        this.volunteerRepo = volunteerRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        throw new BadRequestException("No AVAILABLE volunteers");
    }

    @Override
    public TaskAssignmentRecord updateAssignmentStatus(Long id, String status) {
        TaskAssignmentRecord rec = repo.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Assignment not found"));
        rec.setStatus(status);
        return repo.save(rec);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return repo.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }
}
