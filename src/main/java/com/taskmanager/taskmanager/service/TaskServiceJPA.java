package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.SubTask;
import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;
import com.taskmanager.taskmanager.repository.TaskRepository;
import com.taskmanager.taskmanager.repository.TaskRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("TaskServiceJPA")
public class TaskServiceJPA implements TaskService{

    private final TaskRepositoryJPA taskRepository;
    private int taskId; // houd de laatste ID voor tasks bij. als je een nieuwe task maakt dan pakt hij de huidige ID+1. zo ben je zeker dat je nooit 2 tasks hebt met dezelfde ID.

    @Autowired
    public TaskServiceJPA(TaskRepositoryJPA taskRepository){
        this.taskRepository = taskRepository;
        taskId = 0; // TODO deze moet normaal vanaf 0 beginnen maar omdat er 3 dummy tasks zijn moet dit met 3 beginnen
    }

    @Override
    @Transactional
    public List<TaskDTO> tasks() {
        return taskRepository.findAll().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(h.getId());
            dto.setTitel(h.getTitel());
            dto.setBeschrijving(h.getBeschrijving());
            dto.setDatum(h.getDatum());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addTask(TaskDTO taskDTO) {
        taskId++;
        Task t = new Task(
                taskDTO.getTitel() ,
                taskDTO.getBeschrijving() ,
                taskDTO.getDatum(),
                taskId
        );
        taskRepository.save(t);
    }

    @Override
    @Transactional
    public TaskDTO getTask(int id) {
        Task h = taskRepository.getTaskById(id);
        TaskDTO dto = new TaskDTO();
        dto.setId(h.getId());
        dto.setTitel(h.getTitel());
        dto.setBeschrijving(h.getBeschrijving());
        dto.setDatum(h.getDatum());

        dto.setSubTasks(h.getSubTasks().stream().map(subTask -> {
            SubTaskDTO subDto = new SubTaskDTO();
            subDto.setId(subTask.getId());
            subDto.setTitel(subTask.getTitel());
            subDto.setBeschrijving(subTask.getBeschrijving());
            return subDto;
        }).collect(Collectors.toList()));

        return dto;
    }

    @Override
    @Transactional
    public void updateTask(TaskDTO taskDTO) {
        /*
        // originele manier maar hierdoor werden de subtasks verwijdert
        Task t = new Task(
                taskDTO.getTitel() ,
                taskDTO.getBeschrijving() ,
                taskDTO.getDatum(),
                taskDTO.getId()
        );
        * */

        Task t = taskRepository.getTaskById(taskDTO.getId());
        t.setTitel(taskDTO.getTitel());
        t.setBeschrijving(taskDTO.getBeschrijving());
        t.setDatum(taskDTO.getDatum());
        taskRepository.save(t);
    }

    @Override
    @Transactional
    public void addSubTask(SubTaskDTO subTaskDTO) {
        Task t = taskRepository.getTaskById(subTaskDTO.getId());
        SubTask st = new SubTask(
                subTaskDTO.getTitel(),
                subTaskDTO.getBeschrijving()
        );
        t.addSubTask(st);
        taskRepository.save(t);

    }
}
