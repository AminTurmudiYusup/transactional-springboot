package com.example.transactional.services;

import com.example.transactional.entity.Job;
import com.example.transactional.exception.ResourceEmptyException;
import com.example.transactional.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public void saveJob(Job job) throws ResourceEmptyException {
        if(job.getJobName()==null||job.getJobName().equals("")){
            throw new ResourceEmptyException("Job name can't empty!");
        }
        if (jobRepository.existsJobByJobName(job.getJobName())){
            jobRepository.save(job);
        }else {
            jobRepository.save(job);
        }
    }
}
