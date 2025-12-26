package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.TaskRecord;

public interface TaskRecordRepository {
    Optional<TaskRecord> findByTaskCode(String taskCode);
    List<TaskRecord> findByStatus(String status);
    List<TaskRecord> findAll();
}
