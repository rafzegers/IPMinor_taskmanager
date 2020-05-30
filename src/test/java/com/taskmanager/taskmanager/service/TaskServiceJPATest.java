package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceJPATest {
    @Qualifier("TaskServiceJPA")
    @Autowired
    TaskService tasks;

    @Test
    public void testJPA(){
        TaskDTO t = new TaskDTO();
        t.setId(1);
        t.setTitel("titel");
        t.setBeschrijving("beschrijving");
        t.setDatum(LocalDateTime.now());

        SubTaskDTO s = new SubTaskDTO();
        s.setId(1);
        s.setBeschrijving("yolo");
        s.setTitel("coole titel");

        tasks.addTask(t);

        assertEquals(1, tasks.tasks().size());
        assertNotNull(tasks.getTask(1));
        tasks.addSubTask( s);
        assertEquals(1,tasks.getTask(1).getSubTasks().size());
    }
}
