package validators;

import models.Ticket;
import validators.base.Validator;

import java.util.Date;

public class TicketValidator implements Validator<Ticket> {

    private static final int MIN_TITLE_LENGTH = 3;
    private static final int MAX_TITLE_LENGTH = 20;

    private static final int MIN_OWNER_OR_SENDER_LENGTH = 2;
    private static final int MAX_OWNER_OR_SENDER_LENGTH = 20;

    @Override
    public void validate(Ticket model) throws ValidationException {
        validateTitle(model.getTitle());
        validateOwner(model.getOwner());
        validateSender(model.getSender());
        validateDescription(model.getDescription());
        validateDueDate(model.getDueDate());
    }

    private void validateDueDate(Date dueDate) throws ValidationException {
        if (dueDate.compareTo(new Date()) < 0) {
            throw new ValidationException("Cannot be in the past", "Ticket.dueDate");
        }
    }

    private void validateOwner(String assignee) throws ValidationException {
        if (assignee == null ||
            assignee.length() < MIN_OWNER_OR_SENDER_LENGTH ||
            assignee.length() > MAX_OWNER_OR_SENDER_LENGTH
            ) {
            throw new ValidationException(
                String.format("Must be between %d and %d characters-long",
                    MIN_OWNER_OR_SENDER_LENGTH, MAX_OWNER_OR_SENDER_LENGTH),
                "Ticket.owner");
        }
    }

    private void validateSender(String assignee) throws ValidationException {
        if (assignee == null ||
            assignee.length() < MIN_OWNER_OR_SENDER_LENGTH ||
            assignee.length() > MAX_OWNER_OR_SENDER_LENGTH
            ) {

            throw new ValidationException(
                String.format("Must be between %d and %d characters-long",
                    MIN_OWNER_OR_SENDER_LENGTH, MAX_OWNER_OR_SENDER_LENGTH),
                "Ticket.sender");
        }
    }

    private void validateTitle(String title) throws ValidationException {
        if (title == null ||
            title.length() < MIN_TITLE_LENGTH ||
            title.length() > MAX_TITLE_LENGTH
            ) {
            throw new ValidationException(
                String.format("Must be between %d and %d characters-long", MIN_TITLE_LENGTH, MAX_TITLE_LENGTH),
                "Ticket.title");
        }
    }

    private void validateDescription(String description) throws ValidationException {
        if (description == null) {
            throw new ValidationException("Must be present", "Ticket.description");
        }
    }
}
