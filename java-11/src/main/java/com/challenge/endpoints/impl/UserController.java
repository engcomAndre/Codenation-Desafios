package com.challenge.endpoints.impl;

import com.challenge.endpoints.interfaces.UserControllerInterface;
import com.challenge.entity.User;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/user")
public class UserController implements UserControllerInterface {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<User> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class.getName())));
    }

    @GetMapping
    @Override
    public ResponseEntity<Set<User>> findByRequestParams(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId,
            @RequestParam(value = "accelerationName", required = false, defaultValue = "") String accelerationName) {
        Set<User> users = new HashSet<>();

        users.addAll(userService.findByCompanyId(companyId));
        users.addAll(userService.findByAccelerationName(accelerationName));

        return ResponseEntity.ok().body(users);
    }

}

