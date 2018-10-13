import base.CommandParser;
import base.ProjectManagementSystem;
import commands.Command;
import commands.CommandType;
import models.TicketPriority;
import models.TodoState;
import models.base.Item;
import validators.ValidationException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application {
    private final CommandParser commandParser;
    private ProjectManagementSystem system;

    public Application(CommandParser commandParser, ProjectManagementSystem system) {
        this.system = system;
        this.commandParser = commandParser;
    }

    public void run() throws ParseException {
        Scanner in = new Scanner(System.in);
        while (true) {
            String commandString = in.nextLine();
            Command command = null;
            try {
                command = this.commandParser.parseCommand(commandString);
            } catch (Exception e) {
                System.out.println("Invalid command! Try enter valid command again.");
                continue;
            }

            if (command.getCommandType() == CommandType.EXIT) {
                break;
            }

            try {
                switch (command.getCommandType()) {
                    case ADD_TODO:
                        String todoTitle = command.getParams()[0];
                        String todoDescription = command.getParams()[1];
                        TodoState todoState = TodoState.fromName(command.getParams()[2]);
                        system.addTodo(todoTitle, todoDescription, todoState);
                        break;
                    case ADD_TASK:
                        String taskTitle = command.getParams()[0];
                        String taskDescription = command.getParams()[1];
                        Date taskDueDate = DateFormat.getDateInstance().parse(command.getParams()[2]);
                        TicketPriority taskPriority = TicketPriority.fromName(command.getParams()[3]);
                        int plannedTime = Integer.parseInt(command.getParams()[4]);
                        String assignee = command.getParams()[5];
                        system.addTask(taskTitle, taskDescription, taskDueDate, taskPriority, plannedTime, assignee);
                        break;
                    case ADD_TICKET:
                        String ticketTitle = command.getParams()[0];
                        String ticketDescription = command.getParams()[1];
                        Date ticketDueDate = DateFormat.getDateInstance().parse(command.getParams()[2]);
                        TicketPriority ticketPriority = TicketPriority.fromName(command.getParams()[3]);
                        String sender = command.getParams()[4];
                        String owner = command.getParams()[5];
                        system.addTicket(ticketTitle, ticketDescription, ticketDueDate, ticketPriority, sender, owner);
                        break;
                    case LIST_ALL:
                        print(system.listAll());
                        break;
                    case LIST_TASKS:
                        print(system.listTasks());
                        break;
                    case LIST_TODOS:
                        print(system.listTodos());
                        break;
                    case LIST_TICKETS:
                        print(system.listTickets());
                        break;
                    case LIST_TODOS_NOT_DONE:
                        print(system.listTodos(TodoState.NOT_DONE));
                        break;
                    case UPDATE_TODO:
                        int id = Integer.parseInt(command.getParams()[0]);
                        TodoState newState = TodoState.fromName(command.getParams()[1]);
                        system.changeTodoState(id, newState);
                        break;
                    case SEARCH:
                        String pattern = command.getParams()[0];
                        print(system.searchByTitleOrDescription(pattern));
                }
            } catch (ValidationException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void print(List<Item> items) {
        items.forEach(System.out::println);
    }
}
