package com.challenge.endpoints.impl;

import com.challenge.dto.AccelerationDTO;
import com.challenge.endpoints.interfaces.AccelerationControllerInterface;
import com.challenge.entity.Acceleration;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.mappers.AccelerationMapper;
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

    private AccelerationMapper accelerationMapper;

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AccelerationDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity
                .ok()
                .body(accelerationMapper
                        .map(accelerationService
                                .findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(Acceleration.class.getName()))));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AccelerationDTO>> findByCompanyId(
            @RequestParam(name = "companyId", required = false, defaultValue = "0") Long companyId) {
        return ResponseEntity
                .ok()
                .body(accelerationMapper
                        .map(accelerationService
                                .findByCompanyId(companyId)));
    }
}
