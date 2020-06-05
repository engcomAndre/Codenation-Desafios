package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccelerationService implements AccelerationServiceInterface {

    private final AccelerationRepository accelerationRepository;

    @Autowired
    public AccelerationService(AccelerationRepository accelerationRepository) {
        this.accelerationRepository = accelerationRepository;
    }

    @Override
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    public Optional<Acceleration> findByName(String name) {
        return accelerationRepository.findByName(name);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCandidates_Id_Company_Id(companyId);
    }

    @Override
    public Acceleration save(Acceleration acceleration) {
        return accelerationRepository.save(acceleration);
    }
}
