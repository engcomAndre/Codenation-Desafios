package com.challenge.endpoints.impl;

import com.challenge.endpoints.interfaces.AccelerationControllerInterface;
import com.challenge.entity.Acceleration;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acceleration")
public class AccelerationController implements AccelerationControllerInterface {

    @Autowired
    private AccelerationService accelerationService;


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Acceleration> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(accelerationService.findById(id).orElseThrow(() -> new ResourceNotFoundException(Acceleration.class.getName())));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Acceleration>> findByCompanyId(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId) {
        return ResponseEntity.ok().body(accelerationService.findByCompanyId(companyId));

    }
}
