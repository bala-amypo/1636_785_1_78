package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    @Autowired
    private TaskRecordService service;

    // ✅ CREATE TASK
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return service.createTask(task);
    }

    // ✅ GET TASK BY ID
    @GetMapping("/{id}")
    public TaskRecord getTask(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    // ✅ GET ALL TASKS
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return service.getAllTasks();
    }

    // ✅ UPDATE TASK STATUS
    @PutMapping("/{id}/status")
    public TaskRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
