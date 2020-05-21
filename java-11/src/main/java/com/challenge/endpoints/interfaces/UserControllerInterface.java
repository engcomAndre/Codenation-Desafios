package com.challenge.endpoints.interfaces;

import com.challenge.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface UserControllerInterface {

    ResponseEntity<User> findById(Long id);

    ResponseEntity<Set<User>> findByRequestParams(Long companyId, String accelerationName);
}
