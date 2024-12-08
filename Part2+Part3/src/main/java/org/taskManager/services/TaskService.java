package org.taskManager.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taskManager.entities.Category;
import org.taskManager.entities.Task;
import org.taskManager.entities.enumeration.Priority;
import org.taskManager.repositories.TaskRepository;


import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired // This Annotation enables The Dependency Injection
    private TaskRepository taskRepository;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }

    // Filter Tasks By Priority
    public List<Task> getAllTasksByPriority(Priority priority) {
        return taskRepository.findAllByPriority(priority);
    }

    // Filter Tasks By Category
    public List<Task> getAllTasksByCategory(Category category) {
        return taskRepository.findAllByCategoriesContains(category);
    }

    public List<Task> getAllTasksByDueDate(String dueDate) {
        return taskRepository.findAllByDueDate(LocalDate.parse(dueDate));
    }

    public Task createTask(Task Task) {
        return taskRepository.save(Task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task Task = getTaskById(id);
        Task.setTitle(updatedTask.getTitle());
        Task.setDescription(updatedTask.getDescription());
        Task.setDescription(updatedTask.getDescription());
        return taskRepository.save(Task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

