package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.demo.entity.TaskRecord;
import com.example.demo.service.TaskRecordService;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    @Autowired
    TaskRecordService service;

    // POST /api/tasks
    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return service.createTask(task);
    }

    // PUT /api/tasks/{id}
    @PutMapping("/{id}")
    public TaskRecord update(@PathVariable Long id,
                             @RequestBody TaskRecord task) {
        return service.updateTask(id, task);
    }

    // GET /api/tasks/open
    @GetMapping("/open")
    public List<TaskRecord> openTasks() {
        return service.getOpenTasks();
    }

    // GET /api/tasks/{id}
    @GetMapping("/{id}")
    public TaskRecord getById(@PathVariable Long id) {
        return service.updateTask(id, new TaskRecord());
    }

    // GET /api/tasks
    @GetMapping
    public List<TaskRecord> getAll() {
        return service.getAllTasks();
    }
}
