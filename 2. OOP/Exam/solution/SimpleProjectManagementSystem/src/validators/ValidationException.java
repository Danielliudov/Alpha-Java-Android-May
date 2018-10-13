package validators;

public class ValidationException extends Exception {
    private final String paramName;

    public ValidationException(String reason, String paramName) {
        super(reason);
        this.paramName = paramName;
    }

    @Override
    public String toString() {
        return String.format("%s is invalid for reason: %s",
            paramName, getMessage()
        );
    }
}
