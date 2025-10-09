package com.aviral.myFirstDocumentation.controller;


import com.aviral.myFirstDocumentation.models.Task;
import com.aviral.myFirstDocumentation.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskServices.getAllTasks();
        model.addAttribute("tasks", tasks);
//        return tasks.toString();
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskServices.createTask(title);
//        return tasks.toString();
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskServices.deleteTask(id);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskServices.toggleTask(id);
        return "redirect:/tasks";
    }
}
