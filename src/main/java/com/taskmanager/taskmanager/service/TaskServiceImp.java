package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.SubTask;
import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;
import com.taskmanager.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("TaskServiceImp")
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;
    private int taskId; // houd de laatste ID voor tasks bij. als je een nieuwe task maakt dan pakt hij de huidige ID+1. zo ben je zeker dat je nooit 2 tasks hebt met dezelfde ID.

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        taskId = 3; // TODO deze moet normaal vanaf 0 beginnen maar omdat er 3 dummy tasks zijn moet dit met 3 beginnen
    }

    @Override
    public List<TaskDTO> tasks() {
        return taskRepository.getTasks().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(h.getId());
            dto.setTitel(h.getTitel());
            dto.setBeschrijving(h.getBeschrijving());
            dto.setDatum(h.getDatum());
            return dto;
        }).collect(Collectors.toList());
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
    public TaskDTO getTask(int id){
        Task h = taskRepository.getTask(id);
        TaskDTO dto = new TaskDTO();
        dto.setId(h.getId());
        dto.setTitel(h.getTitel());
        dto.setBeschrijving(h.getBeschrijving());
        dto.setDatum(h.getDatum());
        return dto;
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
