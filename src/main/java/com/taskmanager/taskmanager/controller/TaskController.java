package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;
import com.taskmanager.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.tasks());
        return "tasks";
    }

    @GetMapping("/{id}")
    public String getTask(Model model, @PathVariable("id") Integer id){

        model.addAttribute("task", taskService.getTask(id) );
        return "task";
    }

    @GetMapping("/new")
    public String getNew(){
        return "new";
    }

    @PostMapping("/new")
    public String postNew(@Valid @ModelAttribute TaskDTO taskDTO, BindingResult bindingResult, Errors errors, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getFieldErrors() );
            return "new";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(Model model, @PathVariable("id") Integer id){
        model.addAttribute("task", taskService.getTask(id) );
        return "update";
    }

    @PostMapping("/update")
    public String postUpdate(@ModelAttribute TaskDTO taskDTO){
        taskService.updateTask(taskDTO);
        return "redirect:/tasks/"+taskDTO.getId();
    }

    @RequestMapping("/tasks")
    public String getHome(){
        return "home";
    }


    @GetMapping("/{id}/sub/create")
    public String getCreateSubTask(Model model, @PathVariable("id") Integer id){
        model.addAttribute("id", id );
        return "createSubTask";
    }

    @PostMapping("/sub/create")
    public String postNew(@ModelAttribute SubTaskDTO subTaskDTO){
        taskService.addSubTask(subTaskDTO);
        return "redirect:/tasks/"+subTaskDTO.getId();
    }




}
