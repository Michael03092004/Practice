package org.example;

import java.util.List;
import java.util.Random;

public class Task {
    private int id;
    private String name;
    private State state;
    private Priority priority;
    private final List<Integer> STORY_POINTS = List.of(1, 2, 3, 5, 8, 13, 20, 100);
    private int storyPoint;

    public Task(State state){
        setState(state);
    }
    public Task(Priority priority){
        setPriority(priority);
    }
    public Task() {
        ++id;
        name = "task#" + id;
        setState(State.TO_DO);
        storyPoint = STORY_POINTS.get(new Random().nextInt(0, STORY_POINTS.size()));
        priority = Priority.values()[new Random().nextInt(0, Priority.values().length)];
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getStoryPoint() {
        return storyPoint;
    }

    @Override
    public String toString(){
        return String.valueOf(getPriority());
    }

}
