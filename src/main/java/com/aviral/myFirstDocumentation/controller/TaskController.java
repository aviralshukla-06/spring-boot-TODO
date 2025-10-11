package com.aviral.myFirstDocumentation.controller;

import com.aviral.myFirstDocumentation.models.Task;
import com.aviral.myFirstDocumentation.models.User;
import com.aviral.myFirstDocumentation.repository.TaskRepository;
import com.aviral.myFirstDocumentation.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskController(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // 🔹 Get logged-in user's tasks
    @GetMapping("/me")
    public List<Task> myTasks(Authentication authentication) {
        String email = authentication.getName(); // comes from JWT
        User user = userRepository.findByEmail(email).orElseThrow();
        return taskRepository.findByUser(user);
    }

    // 🔹 Create a new task
    @PostMapping("/me")
    public Task addTask(Authentication authentication, @RequestBody Task task) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow();
        task.setUser(user);
        return taskRepository.save(task);
    }

    // 🔹 Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(Authentication authentication, @PathVariable Long id) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().equals(user)) {
            throw new RuntimeException("Not authorized to delete this task");
        }

        taskRepository.delete(task);
    }

    // 🔹 Toggle task completion (true/false)
    @PatchMapping("/{id}/toggle")
    public Task toggleTask(Authentication authentication, @PathVariable Long id) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().equals(user)) {
            throw new RuntimeException("Not authorized to toggle this task");
        }

        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }
}
