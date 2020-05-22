package com.challenge.endpoints.impl;

import com.challenge.endpoints.interfaces.AccelerationControllerInterface;
import com.challenge.entity.Acceleration;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.service.impl.AccelerationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/acceleration")
public class AccelerationController implements AccelerationControllerInterface {

    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Acceleration> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity
                .ok()
                .body(accelerationService
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(Acceleration.class.getName())));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Acceleration>> findByCompanyId(
            @RequestParam(name = "companyId", required = false, defaultValue = "0") Long companyId) {
        return ResponseEntity.ok().body(accelerationService.findByCompanyId(companyId));
    }
}
