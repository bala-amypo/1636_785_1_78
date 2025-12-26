package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.TaskAssignmentRecord;

public interface TaskAssignmentRecordRepository {
    List<TaskAssignmentRecord> findByTaskId(Long taskId);
    List<TaskAssignmentRecord> findByVolunteerId(String volunteerId);
}
