package org.epde.tfm.service;

import org.epde.tfm.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAll();

    TaskDTO getById(Long id);

    TaskDTO create(TaskDTO dto);

    void delete(Long id);
}
