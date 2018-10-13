package models;

import models.base.Item;

import java.util.Date;

public class Ticket extends Item {
    private String sender;
    private String owner;
    private Date dueDate;
    private TicketPriority priority;

    public Ticket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) {
        super(title, description);
        setDueDate(dueDate);
        setPriority(priority);
        setSender(sender);
        setOwner(owner);
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

    public String getSender() {
        return sender;
    }

    private void setSender(String sender) {
        this.sender = sender;
    }

    public String getOwner() {
        return owner;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("[Ticket]" +
                        "Title: %s" +
                        "Description: %s" +
                        "Due date: %s" +
                        "Priority: %s" +
                        "Sender: %s" +
                        "Owner: %s\n",
                getTitle(), getDescription(), getDueDate(), getPriority(), getSender(), getOwner());
    }
}
