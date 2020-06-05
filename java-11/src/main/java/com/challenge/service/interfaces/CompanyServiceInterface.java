package com.challenge.service.interfaces;

import com.challenge.entity.Company;

import java.util.Optional;
import java.util.Set;

public interface CompanyServiceInterface extends ServiceInterface<Company> {

    Optional<Company> findById(Long id);

    Set<Company> findByAccelerationId(Long accelerationId);

    Set<Company> findByUserId(Long userId);

}
