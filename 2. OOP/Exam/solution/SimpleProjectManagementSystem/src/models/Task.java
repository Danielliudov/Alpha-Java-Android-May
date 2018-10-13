package models;

import models.base.Item;

import java.util.Date;

public class Task extends Item {
    private Date dueDate;
    private TicketPriority priority;
    private int plannedTime;
    private String assignee;

    public Task(String title, String description, Date dueDate, TicketPriority priority, int plannedTime, String assignee) {
        super(title, description);
        setDueDate(dueDate);
        setPriority(priority);
        setPlannedTime(plannedTime);
        setAssignee(assignee);
    }

    public Date getDueDate() {
        return dueDate;
    }

    private void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    private void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public int getPlannedTime() {
        return plannedTime;
    }

    private void setPlannedTime(int plannedTime) {
        this.plannedTime = plannedTime;
    }

    public String getAssignee() {
        return assignee;
    }

    private void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return String.format("[Task]" +
                "Title: %s" +
                "Description: %s" +
                "Due date: %s" +
                "Priority: %s" +
                "Planned time: %d" +
                "Assignee: %s\n",
            getTitle(), getDescription(), getDueDate(), getPriority(), getPlannedTime(), getAssignee());
    }
}
