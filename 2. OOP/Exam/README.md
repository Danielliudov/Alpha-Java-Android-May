# Project management system

Implement a simple **project management system**

The application should support the following oparations:

- Add a ticket
  - Each ticket has a title, description, due date, priority, sender and owner
    - title, description, sender and owner are strings
    - due date is a real date
    - priorities can be either High Priority or Low Priority
- Add a task
  - Each task has a title, description, due date, priority, planned time and assignee
    - title, description and assignee are strings
    - due date is a real date
    - priorities can be either High Priority or Low Priority
- Add a TODO
  - Each TODO has title, description and state
    - title and description are strings
    - state is either Done or Not done 
- List all
  - List all tickets, tasks and TODOs
    - sorted by title
- List tickets
  - List only the tickets
    - sorted by title
- List tasks
  - List only the tasks
    - sorted by title
- List TODOs
  - List only the TODOs
    - sorted by title
- List TODOs that are not done
  - List only the TODOs that are not done
    - sorted by title
- Search by title or descrioption
  - List all tasks, tickets and TODOs that contain the searched text in their title or description 
    - sorted by title
- Change the state of a TODO
  - Think of how to identify different TODOs 

- All list and search commands should print human readable output

Use and extend the project provided:
  - You can **create** any number of classes, interfaces, enums, etc...
  - You can **extend** the provided classes, interfaces and enums where needed
  - You can **change** the existing code only if the change fixes a bug


# Tasks

1. Create the classes Todo, Ticket and Task
2. Implement the ProjectManagementSystemImpl class
3. Separate the work with data entities (get, update) in a separate class(es) and inject it into the ProjectManagementSystemImpl class
4. Implement user input processing
5. Fix any bugs that you find


# General requirements

- Use good practices for object-oriented design
- Add validation on the Todo, Ticket and Task classes
  - Simple validation like string length, past date, not nulll, etc..


# Optional requirements

- Use StreamingAPI where applicable
- Add error handling i.e.
  - invalid command is entered
  - missing or invalid data is provided


# Sample inputs

```
ADD-TODO dishes wash-the-dishes NOT DONE
LIST-TODOs
LIST-ALL
UPDATE-TODO XXXX DONE
EXIT
```
