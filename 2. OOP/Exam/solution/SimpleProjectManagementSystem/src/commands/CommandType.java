package commands;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
    ADD_TASK, ADD_TICKET, ADD_TODO, UPDATE_TODO, LIST_ALL, LIST_TODOS, LIST_TODOS_NOT_DONE, LIST_TICKETS, LIST_TASKS, EXIT, SEARCH;

    private static final String ADD_TODO_COMMAND_NAME = "ADD-TODO";
    private static final String ADD_TASK_COMMAND_NAME = "ADD-TASK";
    private static final String ADD_TICKET_COMMAND_NAME = "ADD-TICKET";
    private static final String LIST_ALL_COMMAND_NAME = "LIST-ALL";
    private static final String LIST_TODOS_COMMAND_NAME = "LIST-TODOS";
    private static final String LIST_TODOS_NOT_DONE_COMMAND_NAME = "LIST-TODOS-NOT-DONE";
    private static final String LIST_TICKETS_COMMAND_NAME = "LIST-TICKETS";
    private static final String LIST_TASKS_COMMAND_NAME = "LIST-TASKS";
    private static final String SEARCH_COMMAND_NAME = "SEARCH";
    private static final String EXIT_COMMAND_NAME = "EXIT";

    private static final Map<String, CommandType> namesToCommandTypes;

    static {
        namesToCommandTypes = new HashMap<>();
        namesToCommandTypes.put(ADD_TASK_COMMAND_NAME, ADD_TASK);
        namesToCommandTypes.put(ADD_TODO_COMMAND_NAME, ADD_TODO);
        namesToCommandTypes.put(ADD_TICKET_COMMAND_NAME, ADD_TICKET);
        namesToCommandTypes.put(LIST_ALL_COMMAND_NAME, LIST_ALL);
        namesToCommandTypes.put(LIST_TODOS_COMMAND_NAME, LIST_TODOS);
        namesToCommandTypes.put(LIST_TODOS_NOT_DONE_COMMAND_NAME, LIST_TODOS_NOT_DONE);
        namesToCommandTypes.put(LIST_TICKETS_COMMAND_NAME, LIST_TICKETS);
        namesToCommandTypes.put(LIST_TASKS_COMMAND_NAME, LIST_TASKS);
        namesToCommandTypes.put(SEARCH_COMMAND_NAME, SEARCH);
        namesToCommandTypes.put(EXIT_COMMAND_NAME, EXIT);
    }

    public static CommandType fromName(String commandName) {
        if (!namesToCommandTypes.containsKey(commandName)) {
            throw new IllegalArgumentException(String.format("Command %s is not recognized.", commandName));
        }

        return namesToCommandTypes.get(commandName);
    }
}
