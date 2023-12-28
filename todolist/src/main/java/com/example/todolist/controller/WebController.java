package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final TaskService taskService;

    @Autowired
    public WebController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new Task()); // For the form
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }
}
