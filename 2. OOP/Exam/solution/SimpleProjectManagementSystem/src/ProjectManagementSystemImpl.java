import base.ProjectManagementSystem;
import data.base.Data;
import models.*;
import models.base.Item;
import validators.ValidationException;
import validators.base.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManagementSystemImpl implements ProjectManagementSystem {

    private final Data<Todo> todosData;
    private final Data<Ticket> ticketsData;
    private final Data<Task> tasksData;
    private final Validator<Todo> todoValidator;
    private final Validator<Ticket> ticketsValidator;
    private final Validator<Task> taskValidator;

    ProjectManagementSystemImpl(
        Data<Todo> todosData,
        Data<Ticket> ticketsData,
        Data<Task> tasksData,
        Validator<Todo> todoValidator,
        Validator<Ticket> ticketsValidator,
        Validator<Task> taskValidator
    ) {
        this.todosData = todosData;
        this.ticketsData = ticketsData;
        this.tasksData = tasksData;
        this.todoValidator = todoValidator;
        this.ticketsValidator = ticketsValidator;
        this.taskValidator = taskValidator;
    }

    @Override
    public void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) throws ValidationException {
        Ticket ticket = new Ticket(title, description, dueDate, priority, sender, owner);
        ticketsValidator.validate(ticket);
        ticketsData.add(ticket);
    }

    @Override
    public void addTodo(String title, String description, TodoState state) throws ValidationException {
        Todo todo = new Todo(title, description, state);
        todoValidator.validate(todo);
        todosData.add(todo);
    }

    @Override
    public void addTask(String title, String description, Date dueDate, TicketPriority priority, int plannedTime, String assignee) throws ValidationException {
        Task task = new Task(title, description, dueDate, priority, plannedTime, assignee);
        taskValidator.validate(task);
        tasksData.add(task);
    }

    @Override
    public List<Item> listAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(todosData.getAll());
        result.addAll(tasksData.getAll());
        result.addAll(ticketsData.getAll());
        result.sort(Comparator.comparing(Item::getTitle));

        return result;
    }

    @Override
    public List<Item> listTickets() {
        return new ArrayList<>(ticketsData.getAll());
    }

    @Override
    public List<Item> listTodos() {
        return new ArrayList<>(todosData.getAll());
    }

    @Override
    public List<Item> listTodos(TodoState state) {
        return todosData.getAll()
            .stream()
            .filter(x -> x.getState().equals(state))
            .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTasks() {
        return new ArrayList<>(tasksData.getAll());
    }

    @Override
    public List<Item> searchByTitleOrDescription(String pattern) {
        return listAll()
            .stream()
            .filter(x -> x.getTitle().contains(pattern) ||
                x.getDescription().contains(pattern))
            .collect(Collectors.toList());
    }

    @Override
    public void changeTodoState(int id, TodoState state) {
        Todo todo = todosData.getById(id);
        todo.setState(state);
    }
}
