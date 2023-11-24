package org.example;

import org.example.Developer;
import org.example.SprintBacklog;
import org.example.State;
import org.example.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperTest {
    Developer developer = new Developer();
    Task task = new Task();

    @Test
    @DisplayName("Get task from sprint backlog method")
    void getTaskFromSprintBacklog() {
        SprintBacklog sprintBacklog = new SprintBacklog(List.of(new Task()));

        developer.getTaskFromSprintBacklog(sprintBacklog, 0);
        assertNotNull(developer.getCurrentTask());
        assertTrue(sprintBacklog.getTaskList().contains(developer.getCurrentTask()));
    }

    @Test
    @DisplayName("Mark task as validate method")
    void markTaskAsValidate() {
        developer.setCurrentTask(task);
        developer.markTaskAsValidate(task);

        assertSame(developer.getCurrentTask().getState(), State.VALIDATE);
    }
}
