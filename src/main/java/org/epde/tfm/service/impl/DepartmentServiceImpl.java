package org.epde.tfm.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.DepartmentDTO;
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
    private final DepartmentRepository repo;

    public List<DepartmentDTO> getAll() {
        List<Department> departments = repo.findAll();
        if (departments.isEmpty()) {
            throw new NotFoundException("No departments found");
        }
        return departments.stream().map(DepartmentMapper::toDto).toList();
    }

    public DepartmentDTO getById(Long id) {
        return repo.findById(id)
                .map(DepartmentMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Department not found with id: " + id));
    }

    public DepartmentDTO create(DepartmentDTO dto) {
        return DepartmentMapper.toDto(repo.save(DepartmentMapper.toEntity(dto)));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Department not found with id: " + id);
        }
        repo.deleteById(id);
    }
}

