package org.epde.tfm.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.request.DepartmentRequest;
import org.epde.tfm.dto.response.DepartmentResponse;
import org.epde.tfm.infrastructure.exception.NotFoundException;
import org.epde.tfm.mapper.DepartmentMapper;
import org.epde.tfm.model.Department;
import org.epde.tfm.repository.DepartmentRepository;
import org.epde.tfm.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    @Override
    public List<DepartmentResponse> getAll() {
        List<Department> departments = repository.findAll();
        if (departments.isEmpty()) {
            throw new NotFoundException("No departments found");
        }
        return departments.stream().map(DepartmentMapper::toResponse).toList();
    }

    @Override
    public DepartmentResponse getById(Long id) {
        return repository.findById(id)
                .map(DepartmentMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Department not found with id: " + id));
    }

    @Override
    public DepartmentResponse create(DepartmentRequest request) {
        Department entity = DepartmentMapper.toEntity(request);
        Department saved = repository.save(entity);
        return DepartmentMapper.toResponse(saved);
    }

    @Override
    public DepartmentResponse update(Long id, DepartmentRequest request) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Department not found with id: " + id);
        }

        Department updated = Department.builder()
                .id(id)
                .name(request.getName())
                .code(request.getCode())
                .location(request.getLocation())
                .build();

        return DepartmentMapper.toResponse(repository.save(updated));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Department not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
