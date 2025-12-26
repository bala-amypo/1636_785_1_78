package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.AssignmentEvaluationRecord;

public interface AssignmentEvaluationRecordRepository {
    List<AssignmentEvaluationRecord> findByAssignmentId(Long assignmentId);
}
