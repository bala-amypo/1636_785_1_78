package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.TaskRecord;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord task);

    List<TaskRecord> getAllTasks();

    List<TaskRecord> getOpenTasks();

    Optional<TaskRecord> getTaskByCode(String code);

    TaskRecord getTaskById(Long id);
    TaskRecord updateTask(Long id, TaskRecord updatedTask);

    TaskRecord updateStatus(Long id, String status);
}
