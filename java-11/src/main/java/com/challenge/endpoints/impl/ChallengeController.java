package com.challenge.endpoints.impl;

import com.challenge.endpoints.interfaces.ChallengeControllerInterface;
import com.challenge.endpoints.interfaces.UserControllerInterface;
import com.challenge.entity.Challenge;
import com.challenge.entity.User;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeController implements ChallengeControllerInterface {


    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return null;
    }
}
