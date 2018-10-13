import base.CommandParser;
import base.ProjectManagementSystem;
import commands.Command;
import commands.CommandType;
import models.TodoState;

import java.util.Scanner;

public class Application {
    private final CommandParser commandParser;
    ProjectManagementSystem system;

    public Application(CommandParser commandParser, ProjectManagementSystem system) {
        this.system = system;
        this.commandParser = commandParser;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String commandString = in.nextLine();
            Command command = this.commandParser.parseCommand(commandString);
            if (command.getCommandType() == CommandType.EXIT) {
                break;
            }

            switch (command.getCommandType()) {
                case ADD_TODO:
                    String title = command.getParams()[0];
                    String description = command.getParams()[1];
                    TodoState state = TodoState.fromName(command.getParams()[2]);
                    system.addTodo(title, description, state);
                    break;
                case ADD_TASK:
                    // TODO: your code here
                    break;
                case ADD_TICKET:
                    // TODO: your code here
                    break;
                case LIST_ALL:
                    // TODO: your code here
                    break;
                case LIST_TASKS:
                    // TODO: your code here
                    break;
                case LIST_TODOS:
                    // TODO: your code here
                    break;
                case UPDATE_TODO:
                    // TODO: your code here
                    break;
                case LIST_TICKETS:
                    // TODO: your code here
                    break;
                case LIST_TODOS_NOT_DONE:
                    // TODO: your code here
                    break;
            }
        }
    }
}
