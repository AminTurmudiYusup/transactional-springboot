package com.example.transactional.repository;

import com.example.transactional.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    boolean existsJobByJobName(String jobName);
}
