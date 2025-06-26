package org.epde.tfm.service;

import org.epde.tfm.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();

    UserDTO getById(Long id);

    UserDTO create(UserDTO dto);

    void delete(Long id);
}
