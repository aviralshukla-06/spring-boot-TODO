package com.aviral.myFirstDocumentation.repository;

import com.aviral.myFirstDocumentation.models.Task;
import com.aviral.myFirstDocumentation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
