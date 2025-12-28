package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/evaluations")
@SecurityRequirement(name="bearerAuth")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluationRecord evaluate(
            @RequestBody AssignmentEvaluationRecord evaluation) {

        return service.evaluateAssignment(evaluation);
    }

    @GetMapping
    public List<AssignmentEvaluationRecord> all() {
        return service.getAllEvaluations();
    }
}

