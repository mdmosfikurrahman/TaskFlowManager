package org.epde.tfm.service;

import org.epde.tfm.dto.request.TaskRequest;
import org.epde.tfm.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAll();
    TaskResponse getById(Long id);
    TaskResponse create(TaskRequest dto);
    TaskResponse update(Long id, TaskRequest dto);
    void delete(Long id);
}