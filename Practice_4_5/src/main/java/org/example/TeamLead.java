package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TeamLead extends Developer{
    private final Position POSITION = Position.TEAM_LEAD;

    public TeamLead(){}
    public TeamLead(String name, String lastName, int salary){
        super(name, lastName, salary);
    }

    public void moveTasksFromProductBacklogToSprint(ProductBacklog productBacklog,
                                                   SprintBacklog sprintBacklog){
        for(Task task : productBacklog.getTaskList()){
            sprintBacklog.add(task);
        }
        productBacklog.getTaskList().removeAll(productBacklog.getTaskList());
    }

    public void markTaskAsDone(Task task){
        task.setState(State.DONE);
    }

    public void inspectSprintBackLog(SprintBacklog sprintBacklog){
        sprintBacklog.getTaskList().removeIf(task -> task.getState() == State.DONE);

    }



}
