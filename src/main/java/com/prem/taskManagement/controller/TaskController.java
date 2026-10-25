
package com.prem.taskManagement.controller;

import com.prem.taskManagement.dto.TaskRequest;
import com.prem.taskManagement.dto.TaskResponse;
import com.prem.taskManagement.service.TaskService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
/*
The controller is where we receive request DTOs and return response DTOs.
The service converts between DTOs and entities, while the repository continues
working with entities.
 */
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(
            @Valid @RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @PostMapping("/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TaskResponse> createMultipleTasks(
            @RequestBody List<@Valid TaskRequest> requests) {
        return taskService.createMultipleTasks(requests);
    }

    @GetMapping
    public List<TaskResponse> findAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponse findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
