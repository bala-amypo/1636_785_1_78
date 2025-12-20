package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TaskRecord;
import java.util.List;

public interface TaskRecordRepository
        extends JpaRepository<TaskRecord, Long> {

    List<TaskRecord> findByStatus(String status);

    TaskRecord findByTaskCode(String code);
}
