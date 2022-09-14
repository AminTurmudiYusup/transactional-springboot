package com.example.transactional.controller;

import com.example.transactional.dto.Registration;
import com.example.transactional.exception.ResourceAlreadyExistException;
import com.example.transactional.exception.ResourceEmptyException;
import com.example.transactional.exception.ResourceNotSatisfiable;
import com.example.transactional.services.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationServices registrationServices;

    @PostMapping("/user/registration")
    public Registration userRegistration(@RequestBody Registration registration) throws ResourceEmptyException, ResourceAlreadyExistException, ResourceNotSatisfiable {
        registrationServices.registration(registration);
        return registration;
    }
}
