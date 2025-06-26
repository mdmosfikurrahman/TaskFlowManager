package org.epde.tfm.features.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.features.users.dto.request.UserRequest;
import org.epde.tfm.features.users.dto.response.UserResponse;
import org.epde.tfm.common.exception.NotFoundException;
import org.epde.tfm.features.users.mapper.UserMapper;
import org.epde.tfm.features.departments.model.Department;
import org.epde.tfm.features.users.model.User;
import org.epde.tfm.features.departments.repository.DepartmentRepository;
import org.epde.tfm.features.users.repository.UserRepository;
import org.epde.tfm.features.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final DepartmentRepository deptRepo;

    @Override
    public List<UserResponse> getAll() {
        List<UserResponse> users = repo.findAll().stream().map(UserMapper::toResponse).toList();
        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
        return users;
    }

    @Override
    public UserResponse getById(Long id) {
        return repo.findById(id)
                .map(UserMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @Override
    public UserResponse create(UserRequest dto) {
        Department dept = deptRepo.findById(dto.getDepartmentId())
                .orElseThrow(() -> new NotFoundException("Department not found with id: " + dto.getDepartmentId()));
        return UserMapper.toResponse(repo.save(UserMapper.toEntity(dto, dept)));
    }

    @Override
    public UserResponse update(Long id, UserRequest dto) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("User not found with id: " + id);
        }
        Department dept = deptRepo.findById(dto.getDepartmentId())
                .orElseThrow(() -> new NotFoundException("Department not found with id: " + dto.getDepartmentId()));

        User updated = User.builder()
                .id(id)
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .position(dto.getPosition())
                .department(dept)
                .build();

        return UserMapper.toResponse(repo.save(updated));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("User not found with id: " + id);
        }
        repo.deleteById(id);
    }
}