package com.todo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testAddTask() {
        App.addTask("Task 1");
        assertEquals(1, App.getTasks().size());
        assertEquals("Task 1", App.getTasks().get(0).getText());
    }

    @Test
    public void testMarkDone() {
        App.addTask("Task 2");
        App.markDone(2);
        assertTrue(App.getTasks().get(1).isDone());
    }
}
