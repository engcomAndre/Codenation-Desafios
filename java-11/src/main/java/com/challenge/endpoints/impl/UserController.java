package com.challenge.endpoints.impl;

import com.challenge.endpoints.interfaces.UserControllerInterface;
import com.challenge.entity.User;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController implements UserControllerInterface {

    private UserService userService;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class.getName())));
    }

    @Override
    @GetMapping
    public ResponseEntity<Set<User>> findByRequestParams(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId,
            @RequestParam(value = "accelerationName", required = false, defaultValue = "") String accelerationName) {

        Set<User> users = new HashSet<>();
        if (companyId != 0) users.addAll(userService.findByCompanyId(companyId));
        if (!accelerationName.isEmpty()) users.addAll(userService.findByAccelerationName(accelerationName));
        return ResponseEntity.ok().body(users);
    }
}




