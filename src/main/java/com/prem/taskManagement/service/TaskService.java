package com.prem.taskManagement.service;

import com.prem.taskManagement.dto.TaskRequest;
import com.prem.taskManagement.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest taskRequest);

    List<TaskResponse> createMultipleTasks(
            List<TaskRequest> tasks);

    List<TaskResponse> findAllTasks();

    TaskResponse findTaskById(Long id);

    TaskResponse updateTask(Long id, TaskRequest taskRequest);

    void deleteTask(Long id);
}