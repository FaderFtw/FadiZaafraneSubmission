package org.taskManager.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taskManager.entities.Category;
import org.taskManager.entities.Task;
import org.taskManager.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    
    @Autowired // This Annotation enables The Dependency Injection
    private CategoryRepository CategoryRepository;

    public List<Category> getAllCategories() {
        return CategoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return CategoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public Category createCategory(Category Category) {
        return CategoryRepository.save(Category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category Category = getCategoryById(id);
        Category.setName(updatedCategory.getName());
        return CategoryRepository.save(Category);
    }

    public void assignTasksToOneOrMoreCategories(Task task, List<Category> categories){
        //TODO
    }

    public void deleteCategory(Long id) {
        CategoryRepository.deleteById(id);
    }
}

