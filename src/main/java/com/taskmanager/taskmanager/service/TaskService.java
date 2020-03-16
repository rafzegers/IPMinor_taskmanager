package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    public List<Task> tasks();

    public void addTask(TaskDTO task);

    public Task getTask(int id);

    public void updateTask(TaskDTO task);

    public void addSubTask(SubTaskDTO subTaskDTO);
}
