import base.CommandParser;
import base.ProjectManagementSystem;
import data.GenericData;
import data.base.Data;
import models.Task;
import models.Ticket;
import models.Todo;
import validators.TaskValidator;
import validators.TicketValidator;
import validators.TodoValidator;
import validators.base.Validator;

import java.io.ByteArrayInputStream;
import java.text.ParseException;

public class Main {

    static void fakeInput() {
        String test = "ADD-TODO wash-the-dishes NOT DONE\n" +
            "LIST-TODOs\n" +
            "LIST-ALL\n" +
            "UPDATE-TODO XXXX DONE\n" +
            "EXIT\n";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws ParseException {
        fakeInput();
        CommandParser parser = new CommandParserImpl();

        Data<Task> tasksData = new GenericData<>();
        Data<Ticket> ticketsData = new GenericData<>();
        Data<Todo> todosData = new GenericData<>();

        Validator<Ticket> ticketsValidator = new TicketValidator();
        Validator<Todo> todoValidator = new TodoValidator();
        Validator<Task> taskValidator = new TaskValidator();

        ProjectManagementSystem system =
            new ProjectManagementSystemImpl(todosData, ticketsData, tasksData,
                todoValidator, ticketsValidator, taskValidator);

        Application app = new Application(parser, system);
        app.run();
    }
}