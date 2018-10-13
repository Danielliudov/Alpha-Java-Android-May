package models;

import models.base.Item;

public class Todo extends Item {
    private TodoState state;

    public Todo(String title, String description, TodoState state) {
        super(title, description);
        setState(state);
    }

    public TodoState getState() {
        return state;
    }

    public void setState(TodoState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("[TODO]" +
                        "Title: %s" +
                        "Description: %s" +
                        "State: %s\n",
                getTitle(), getDescription(), getState());
    }
}
