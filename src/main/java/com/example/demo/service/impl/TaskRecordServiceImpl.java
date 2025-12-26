package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repo;

    public TaskRecordServiceImpl(TaskRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        task.setStatus("OPEN");
        return repo.save(task);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repo.findAll();
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }

    @Override
    public Optional<TaskRecord> getTaskByCode(String code) {
        return repo.findByTaskCode(code);
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Task not found"));
    }

    @Override
    public TaskRecord updateStatus(Long id, String status) {
        TaskRecord task = getTaskById(id);
        task.setStatus(status);
        return repo.save(task);
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord updatedTask) {

        TaskRecord existing = getTaskById(id);

        existing.setTaskName(updatedTask.getTaskName());
        existing.setRequiredSkill(updatedTask.getRequiredSkill());
        existing.setRequiredSkillLevel(updatedTask.getRequiredSkillLevel());
        existing.setPriority(updatedTask.getPriority());
        existing.setStatus(updatedTask.getStatus());

        return repo.save(existing);
    }

}
