package org.epde.tfm.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.UserDTO;
import org.epde.tfm.infrastructure.exception.NotFoundException;
import org.epde.tfm.mapper.UserMapper;
import org.epde.tfm.model.Department;
import org.epde.tfm.repository.DepartmentRepository;
import org.epde.tfm.repository.UserRepository;
import org.epde.tfm.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final DepartmentRepository deptRepo;

    public List<UserDTO> getAll() {
        List<UserDTO> users = repo.findAll().stream().map(UserMapper::toDto).toList();
        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
        return users;
    }

    public UserDTO getById(Long id) {
        return repo.findById(id)
                .map(UserMapper::toDto)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    public UserDTO create(UserDTO dto) {
        Department dept = deptRepo.findById(dto.getDepartmentId())
                .orElseThrow(() -> new NotFoundException("Department not found with id: " + dto.getDepartmentId()));
        return UserMapper.toDto(repo.save(UserMapper.toEntity(dto, dept)));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("User not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
