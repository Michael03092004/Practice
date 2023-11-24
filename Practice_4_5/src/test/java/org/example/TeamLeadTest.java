package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class TeamLeadTest {
    TeamLead teamLead = new TeamLead();
    Task task = new Task();

    @Test
    @DisplayName("Move tasks from product backlog to sprint method")
    void moveTasksFromProductBacklogToSprint() {
        ProductBacklog productBacklog = new ProductBacklog();

        Task task1 = new Task();
        Task task2 = new Task();

        productBacklog.add(task1);
        productBacklog.add(task2);

        SprintBacklog sprintBacklog = new SprintBacklog();

        teamLead.moveTasksFromProductBacklogToSprint(productBacklog, sprintBacklog);

        assertTrue(productBacklog.getTaskList().isEmpty());
        assertTrue(sprintBacklog.getTaskList().containsAll(List.of(task1, task2)));
    }


    @Test
    @DisplayName("Mark task as done method")
    void markTaskAsDone() {
        teamLead.setCurrentTask(task);
        teamLead.markTaskAsDone(task);

        assertSame(teamLead.getCurrentTask().getState(), State.DONE);
    }

    @Test
    @DisplayName("Inspect sprint backlog method")
    void inspectSprintBackLog() {
        List<Task> tasks = new ArrayList<Task>();

        tasks.add(new Task(State.DONE));
        tasks.add(new Task(State.VALIDATE));
        tasks.add(new Task(State.DONE));

        SprintBacklog sprintBacklog = new SprintBacklog(tasks);

        teamLead.inspectSprintBackLog(sprintBacklog);
        assertEquals(1, sprintBacklog.getTaskList().size());
        assertSame(sprintBacklog.getTaskList().get(0).getState(), State.VALIDATE);
    }
}