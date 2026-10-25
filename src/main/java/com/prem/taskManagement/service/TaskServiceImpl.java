
package com.prem.taskManagement.service;

import com.prem.taskManagement.dto.TaskRequest;
import com.prem.taskManagement.dto.TaskResponse;
import com.prem.taskManagement.entity.Tasks;
import com.prem.taskManagement.exception.TaskNotFoundException;
import com.prem.taskManagement.repository.TaskRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Convert request DTO to entity, then save it
    @Override
    public TaskResponse createTask(TaskRequest request) {
        Tasks task = new Tasks();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());

        Tasks savedTask = taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    // Save multiple tasks using saveAll()
    @Override
    @Transactional
    public List<TaskResponse> createMultipleTasks(
            List<TaskRequest> requests) {

        List<Tasks> tasks = requests.stream()
                .map(this::mapToEntity)
                .toList();

        return taskRepository.saveAll(tasks).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<TaskResponse> findAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TaskResponse findTaskById(Long id) {
        Tasks task = getTaskOrThrow(id);
        return mapToResponse(task);
    }

    @Override
    public TaskResponse updateTask(
            Long id, TaskRequest request) {

        Tasks task = getTaskOrThrow(id);

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());

        return mapToResponse(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id) {
        Tasks task = getTaskOrThrow(id);
        taskRepository.delete(task);
    }

    private Tasks getTaskOrThrow(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(
                                "Task not found with id: " + id));
    }

    // Convert request DTO to entity
    private Tasks mapToEntity(TaskRequest request) {
        Tasks task = new Tasks();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());
        return task;
    }

    // Convert entity to response DTO
    private TaskResponse mapToResponse(Tasks task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setCompleted(task.isCompleted());
        response.setCreatedAt(task.getCreatedAt());
        return response;
    }
}
