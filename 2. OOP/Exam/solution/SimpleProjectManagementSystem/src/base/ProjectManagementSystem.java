package base;

import models.TicketPriority;
import models.TodoState;
import models.base.Item;
import validators.ValidationException;

import java.util.Date;
import java.util.List;

public interface ProjectManagementSystem {

    void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) throws ValidationException;

    void addTodo(String title, String description, TodoState state) throws ValidationException;

    void addTask(String title, String description, Date dueDate, TicketPriority priority, int plannedTime, String assignee) throws ValidationException;

    List<Item> listAll();

    List<Item> listTickets();

    List<Item> listTodos();

    List<Item> listTodos(TodoState state);

    List<Item> listTasks();

    List<Item> searchByTitleOrDescription(String pattern);

    void changeTodoState(int id, TodoState state);
}
