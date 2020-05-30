package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDTO> tasks();

    void addTask(TaskDTO task);

    TaskDTO getTask(int id);

    void updateTask(TaskDTO task);

    void addSubTask(SubTaskDTO subTaskDTO);
}
