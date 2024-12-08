package org.taskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskManager.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
