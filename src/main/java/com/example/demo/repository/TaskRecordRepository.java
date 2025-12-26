package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaskRecord;

@Repository
public interface TaskRecordRepository
        extends JpaRepository<TaskRecord, Long> {

    Optional<TaskRecord> findByTaskCode(String taskCode);

    List<TaskRecord> findByStatus(String status);
    
}
