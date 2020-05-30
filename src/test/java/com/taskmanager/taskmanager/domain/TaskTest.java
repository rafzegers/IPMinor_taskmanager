package com.taskmanager.taskmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTask(){
        Task t = new Task();
        assertNotNull(t);
        assertEquals(0, t.getSubTasks().size());
    }

    @Test
    public void testContentTask(){
        Task t = new Task();
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
    public void testTaskWithSubtask(){
        Task t = new Task();
        t.setId(1);
        t.setTitel("titel");
        t.setBeschrijving("beschrijving");
        t.setDatum(LocalDateTime.of(2020, 1, 1, 12, 0));

        SubTask s = new SubTask();
        s.setId(1);
        s.setTitel("titel");
        s.setBeschrijving("beschrijving");

        t.addSubTask(s);

        assertNotNull(t.getSubTasks());
        assertEquals(s , t.getSubTasks().get(0) );

    }

}
