package org.taskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskManager.entities.Category;
import org.taskManager.entities.Task;
import org.taskManager.entities.enumeration.Priority;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByPriority(Priority priority);
    List<Task> findAllByCategoriesContains(Category category);
    List<Task> findAllByDueDate(LocalDate dueDate);

}
