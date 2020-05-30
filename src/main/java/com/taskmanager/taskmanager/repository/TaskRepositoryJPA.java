package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryJPA extends JpaRepository<Task, Long> {
    void deleteTaskById(int id);
    Task getTaskById(int id);
}
