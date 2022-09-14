package com.example.transactional.services;

import com.example.transactional.entity.User;
import com.example.transactional.exception.ResourceAlreadyExistException;
import com.example.transactional.exception.ResourceEmptyException;
import com.example.transactional.exception.ResourceNotSatisfiable;
import com.example.transactional.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void saveUser(User user) throws ResourceEmptyException, ResourceAlreadyExistException, ResourceNotSatisfiable {
        if(user.getFirstName()==null){
            throw new ResourceEmptyException("First name can't empty!");
        }
        if(user.getLastName()==null){
            throw new ResourceEmptyException("Last name can't empty!");
        }
        if(user.getAge()<18){
            throw new ResourceNotSatisfiable("age not allowed under 18!");
        }
        if(user.getEmail()==null){
            throw new ResourceEmptyException("email can't empty!");
        }
        if(user.getPhone()==null){
            throw new ResourceEmptyException("phone can't empty!");
        }
        if(user.getJobName()==null){
            throw new ResourceEmptyException("Job name can't empty!");
        }
        if(userRepository.existsUserByEmail(user.getEmail())){
        throw new ResourceAlreadyExistException("email already exist!");
        }
        if(userRepository.existsUserByPhone(user.getPhone())){
            throw new ResourceAlreadyExistException("phone number already exist!");
        }
        userRepository.save(user);
    }
}
