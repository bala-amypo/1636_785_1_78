package com.example.demo.controller;

import com.example.demo.dto.TaskRecordRequestDTO;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecordRequestDTO dto) {
        TaskRecord t = new TaskRecord();
        t.setTaskCode(dto.getTaskCode());
        t.setTaskName(dto.getTaskName());
        t.setRequiredSkill(dto.getRequiredSkill());
        t.setRequiredSkillLevel(dto.getRequiredSkillLevel());
        t.setPriority(dto.getPriority());
        return service.createTask(t);
    }

    @GetMapping("/{id}")
    public TaskRecord getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @GetMapping("/code/{code}")
    public TaskRecord getTaskByCode(@PathVariable String code) {
        return service.getTaskByCode(code);
    }

    @PatchMapping("/{id}/status")
    public TaskRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
