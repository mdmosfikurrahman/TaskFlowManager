package org.epde.tfm.tasks.service;

import org.epde.tfm.tasks.dto.request.TaskRequest;
import org.epde.tfm.tasks.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAll();
    TaskResponse getById(Long id);
    TaskResponse create(TaskRequest dto);
    TaskResponse update(Long id, TaskRequest dto);
    void delete(Long id);
}