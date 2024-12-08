package org.taskManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.taskManager.entities.Category;
import org.taskManager.entities.Task;
import org.taskManager.entities.enumeration.Priority;
import org.taskManager.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/Tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping
    public List<Task> getAllTasksByPriority(@RequestParam String priority) {
        return taskService.getAllTasksByPriority(Priority.valueOf(priority));
    }

    @GetMapping
    public List<Task> getAllTasksByCategory(@RequestBody Category category) {
        return taskService.getAllTasksByCategory(category);
    }

    @GetMapping
    public List<Task> getAllTasksByDueDate(@RequestParam String dueDate) {
        return taskService.getAllTasksByDueDate(dueDate);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

