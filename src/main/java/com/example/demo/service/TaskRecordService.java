package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TaskRecord;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord task);

    TaskRecord updateTask(Long id, TaskRecord updated);

    List<TaskRecord> getOpenTasks();

    TaskRecord getTaskByCode(String code);

    List<TaskRecord> getAllTasks();
}
