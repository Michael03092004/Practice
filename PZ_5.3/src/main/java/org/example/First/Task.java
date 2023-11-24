package org.example.First;

public class Task {

    private final User owner;
    public Task(User owner){
        this.owner = owner;
    }


    public User getOwner(){
        return owner;
    }
}
