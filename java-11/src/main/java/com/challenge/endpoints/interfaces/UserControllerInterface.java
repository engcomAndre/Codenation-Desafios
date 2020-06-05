package com.challenge.endpoints.interfaces;

import com.challenge.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserControllerInterface {

    ResponseEntity<UserDTO> findById(Long id);

    ResponseEntity<List<UserDTO>> findByRequestParams(Long companyId, String accelerationName);
}
