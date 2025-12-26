package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    @PostMapping
    public TaskRecord createTask(
            @RequestBody TaskRecord task) {
        return service.createTask(task);
    }

    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return service.getOpenTasks();
    }

    @GetMapping("/{id}")
    public TaskRecord getTaskById(
            @PathVariable Long id) {
        return service.getTaskById(id);
    }

    @PutMapping("/{id}/status")
    public TaskRecord updateTaskStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
