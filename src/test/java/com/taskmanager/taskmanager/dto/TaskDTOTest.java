package com.taskmanager.taskmanager.dto;

import com.taskmanager.taskmanager.domain.SubTask;
import com.taskmanager.taskmanager.domain.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskDTOTest {

    @Test
    public void testTaskDTO(){
        TaskDTO t = new TaskDTO();
        assertNotNull(t);
        //assertEquals(0, t.getSubTasks().size());
    }

    @Test
    public void testContentTaskDTO(){
        TaskDTO t = new TaskDTO();
        t.setId(1);
        t.setTitel("titel");
        t.setBeschrijving("beschrijving");
        t.setDatum(LocalDateTime.of(2020, 1, 1, 12, 0));

        assertNotNull(t);
        assertEquals("titel", t.getTitel());
        assertEquals("beschrijving", t.getBeschrijving());
        assertEquals(LocalDateTime.of(2020, 1, 1, 12, 0), t.getDatum());
    }

    @Test
    public void testTaskWithSubtaskDTO(){
        TaskDTO t = new TaskDTO();
        t.setId(1);
        t.setTitel("titel");
        t.setBeschrijving("beschrijving");
        t.setDatum(LocalDateTime.of(2020, 1, 1, 12, 0));

        SubTaskDTO s = new SubTaskDTO();
        s.setId(1);
        s.setTitel("titel");
        s.setBeschrijving("beschrijving");

        List<SubTaskDTO> subTaskDTOList = new LinkedList<>();
        subTaskDTOList.add(s);
        t.setSubTasks(subTaskDTOList);

        assertNotNull(t.getSubTasks());
        assertEquals(s , t.getSubTasks().get(0) );
        assertEquals(subTaskDTOList , t.getSubTasks() );

    }

}
