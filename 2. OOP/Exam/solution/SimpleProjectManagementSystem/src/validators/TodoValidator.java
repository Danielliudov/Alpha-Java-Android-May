package validators;

import models.Todo;
import validators.base.Validator;

public class TodoValidator implements Validator<Todo> {
    private static final int MIN_TITLE_LENGTH = 3;
    private static final int MAX_TITLE_LENGTH = 20;

    @Override
    public void validate(Todo model) throws ValidationException {
        validateTitle(model.getTitle());
        validateDescription(model.getDescription());
    }

    private void validateTitle(String title) throws ValidationException {
        if (title == null ||
            title.length() < MIN_TITLE_LENGTH ||
            title.length() > MAX_TITLE_LENGTH
            ) {
            throw new ValidationException(
                String.format("Must be between %d and %d characters-long", MIN_TITLE_LENGTH, MAX_TITLE_LENGTH),
                "Todo.title");
        }
    }

    private void validateDescription(String description) throws ValidationException {
        if (description == null) {
            throw new ValidationException("Must be present", "Todo.description");
        }
    }
}
