package org.example;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductBacklogTest {

    ProductBacklog productBacklog = new ProductBacklog();

    @Test
    void add() {
        Task task0 = new Task(Priority.LOW);
        Task task1 = new Task(Priority.HIGH);
        Task task2 = new Task(Priority.CRITICAL);

        productBacklog.add(task0);
        productBacklog.add(task1);
        productBacklog.add(task2);

        assertEquals(3, productBacklog.getTaskList().size());
        assertEquals(Objects.requireNonNull(productBacklog.getTaskList().poll()).getPriority(),
                Priority.CRITICAL);
        assertEquals(Objects.requireNonNull(productBacklog.getTaskList().poll()).getPriority(),
                Priority.HIGH);
        assertEquals(Objects.requireNonNull(productBacklog.getTaskList().poll()).getPriority(),
                Priority.LOW);
    }

    @Test
    void delete() {
        Task task = new Task();
        productBacklog.add(task);
        productBacklog.delete();

        assertTrue(productBacklog.getTaskList().isEmpty());
        assertFalse(productBacklog.getTaskList().contains(task));
    }
}