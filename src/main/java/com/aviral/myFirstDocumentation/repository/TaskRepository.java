package com.aviral.myFirstDocumentation.repository;

import com.aviral.myFirstDocumentation.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
