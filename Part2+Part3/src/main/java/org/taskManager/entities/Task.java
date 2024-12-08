package org.taskManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.taskManager.entities.enumeration.Priority;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Priority priority;
    private LocalDate dueDate;
    private Boolean status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tasks")
    @JsonIgnore
    private List<Category> categories;

}

