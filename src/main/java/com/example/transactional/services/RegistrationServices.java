package com.example.transactional.services;

import com.example.transactional.dto.Registration;
import com.example.transactional.entity.Job;
import com.example.transactional.entity.User;
import com.example.transactional.exception.ResourceAlreadyExistException;
import com.example.transactional.exception.ResourceEmptyException;
import com.example.transactional.exception.ResourceNotSatisfiable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServices {
    @Autowired
    private JobService jobService;
    @Autowired
    private UserService userService;
    @Transactional(propagation = Propagation.REQUIRED)
    public Registration registration(Registration registration) throws ResourceEmptyException, ResourceAlreadyExistException, ResourceNotSatisfiable {
        Job job=new Job();
        job.setJobName(registration.getJobName());
        jobService.saveJob(job);
        User user=User.builder().firstName(registration.getFirstName()).lastName(registration.getLastName()).age(registration.getAge()).email(registration.getEmail()).phone(registration.getPhone()).jobName(registration.getJobName()).build();
        userService.saveUser(user);
        return registration;
    }
}
