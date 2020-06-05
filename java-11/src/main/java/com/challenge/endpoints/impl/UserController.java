package com.challenge.endpoints.impl;

import com.challenge.dto.UserDTO;
import com.challenge.endpoints.interfaces.UserControllerInterface;
import com.challenge.entity.User;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.mappers.UserMapper;
import com.challenge.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController implements UserControllerInterface {

    private UserService userService;

    private UserMapper userMapper;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity
                .ok()
                .body(userMapper.map(userService
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(User.class.getName()))));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserDTO>> findByRequestParams(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId,
            @RequestParam(value = "accelerationName", required = false, defaultValue = "") String accelerationName) {

        Set<User> users = new HashSet<>();
        if (companyId != 0) users.addAll(userService.findByCompanyId(companyId));
        if (!accelerationName.isEmpty()) users.addAll(userService.findByAccelerationName(accelerationName));


        return ResponseEntity.ok().body(userMapper.map(users));
    }
}




