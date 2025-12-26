package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluationRecord evaluateAssignment(
            @RequestBody AssignmentEvaluationRecord record) {
        return service.evaluateAssignment(record);
    }

    @GetMapping
    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return service.getAllEvaluations();
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            @PathVariable Long assignmentId) {
        return service.getEvaluationsByAssignment(assignmentId);
    }
}
