package com.taskmanager.taskmanager.domain;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class SubTaskTest {

    @Test
    public void testSubTask(){
        SubTask st = new SubTask();
        assertNotNull(st);
    }

    @Test
    public void testContentSubTask(){
        SubTask st = new SubTask();
        st.setId(1);
        st.setTitel("titel");
        st.setBeschrijving("beschrijving");

        assertNotNull(st);
        assertEquals(1,st.getId());
        assertEquals("titel", st.getTitel());
        assertEquals("beschrijving", st.getBeschrijving());
    }
}
