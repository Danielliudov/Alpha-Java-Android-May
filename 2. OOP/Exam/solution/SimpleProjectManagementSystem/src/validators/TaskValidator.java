package validators;

import models.Task;
import validators.base.Validator;

import java.util.Date;

public class TaskValidator implements Validator<Task> {
    private static final int MIN_TITLE_LENGTH = 3;
    private static final int MAX_TITLE_LENGTH = 20;
    private static final int MIN_ASSIGNEE_LENGTH = 2;
    private static final int MAX_ASSIGNEE_LENGTH = 30;

    @Override
    public void validate(Task model) throws ValidationException {
        validateTitle(model.getTitle());
        validateAssignee(model.getAssignee());
        validateDescription(model.getDescription());
        validateDueDate(model.getDueDate());
        validatePlannedTime(model.getPlannedTime());
    }

    private void validatePlannedTime(int plannedTime) throws ValidationException {
        if (plannedTime < 1) {
            throw new ValidationException("Cannot be less than 1", "Task.plannedTime");
        }
    }

    private void validateDueDate(Date dueDate) throws ValidationException {
        if (dueDate.compareTo(new Date()) < 0) {
            throw new ValidationException("Cannot be in the past", "Task.dueDate");
        }
    }

    private void validateAssignee(String assignee) throws ValidationException {
        if (assignee == null ||
            assignee.length() < MIN_ASSIGNEE_LENGTH ||
            assignee.length() > MAX_ASSIGNEE_LENGTH
            ) {
            throw new ValidationException(
                String.format("Must be between %d and %d characters-long", MIN_TITLE_LENGTH, MAX_TITLE_LENGTH),
                "Task.assignee");
        }
    }

    private void validateTitle(String title) throws ValidationException {
        if (title == null ||
            title.length() < MIN_TITLE_LENGTH ||
            title.length() > MAX_TITLE_LENGTH
            ) {
            throw new ValidationException(
                String.format("Must be between %d and %d characters-long", MIN_TITLE_LENGTH, MAX_TITLE_LENGTH),
                "Task.title");
        }
    }

    private void validateDescription(String description) throws ValidationException {
        if (description == null) {
            throw new ValidationException("Must be present", "Task.description");
        }
    }
}
