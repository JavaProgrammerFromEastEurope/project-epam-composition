package by.epam.composite.application.exception;

import static java.lang.String.format;

/**
 * The exception throws when the User choose invalid values
 * - applies for: Console Application
 */
public class WrongValueException extends Exception {

    private final int value;

    public WrongValueException(int value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        int character = 122891;
        return format("Don't be a stranger, world is beautiful %c  !" +
                " %d - is Wrong!", (char) character, value);
    }
}
