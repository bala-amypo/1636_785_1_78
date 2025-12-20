package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Autowired
    TaskRecordRepository repo;

    public TaskRecord createTask(TaskRecord task) {
        return repo.save(task);
    }

    public TaskRecord updateTask(Long id, TaskRecord updated) {
        TaskRecord t = repo.findById(id).orElse(null);
        if (t != null) {
            t.setTaskName(updated.getTaskName());
            t.setRequiredSkill(updated.getRequiredSkill());
            t.setRequiredSkillLevel(updated.getRequiredSkillLevel());
            t.setPriority(updated.getPriority());
            t.setStatus(updated.getStatus());
            return repo.save(t);
        }
        return null;
    }

    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }

    public TaskRecord getTaskByCode(String code) {
        return repo.findByTaskCode(code);
    }

    public List<TaskRecord> getAllTasks() {
        return repo.findAll();
    }
}
