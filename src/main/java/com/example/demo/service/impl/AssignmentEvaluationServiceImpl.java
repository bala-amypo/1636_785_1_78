package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;

@Service
public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repo;
    private final TaskAssignmentRecordRepository assignmentRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository repo,
            TaskAssignmentRecordRepository assignmentRepo) {
        this.repo = repo;
        this.assignmentRepo = assignmentRepo;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord record) {

        assignmentRepo.findById(record.getAssignmentId())
                .orElseThrow(() ->
                        new BadRequestException("Assignment not found"));

        return repo.save(record);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            Long assignmentId) {
        return repo.findByAssignmentId(assignmentId);
    }

    @Override
    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return repo.findAll();
    }
}
