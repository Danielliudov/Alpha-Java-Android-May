package validators.base;

import validators.ValidationException;

public interface Validator<T> {
    void validate(T model) throws ValidationException;
}
