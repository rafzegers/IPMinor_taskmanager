package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.SubTask;
import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;
import com.taskmanager.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;
    private int taskId; // houd de laatste ID voor tasks bij. als je een nieuwe task maakt dan pakt hij de huidige ID+1. zo ben je zeker dat je nooit 2 tasks hebt met dezelfde ID.

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        taskId = 3; // TODO deze moet normaal vanaf 0 beginnen maar omdat er 3 dummy tasks zijn moet dit met 3 beginnen
    }

    @Override
    public List<Task> tasks() {
        return taskRepository.getTasks();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        taskId++;
        taskRepository.addTask(new Task(
                taskDTO.getTitel() ,
                taskDTO.getBeschrijving() ,
                taskDTO.getDatum(),
                taskId)
        );
    }

    @Override
    public Task getTask(int id){
        return taskRepository.getTask(id);
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {

        taskRepository.updateTask(new Task(
                taskDTO.getTitel() ,
                taskDTO.getBeschrijving() ,
                taskDTO.getDatum(),
                taskDTO.getId() )
        );

    }

    @Override
    public void addSubTask(SubTaskDTO subTaskDTO) {
        taskRepository.addSubTask(new SubTask(
                subTaskDTO.getTitel(),
                subTaskDTO.getBeschrijving()
        ),
                subTaskDTO.getId()
        );
    }

}
