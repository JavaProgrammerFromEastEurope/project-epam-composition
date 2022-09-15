package by.epam.composite.application.exception;

/**
 * The exception throws when the application terminate
 * - applies for: Console Application
 */
public class StopApplicationException extends Exception {
    @Override
    public String getMessage() {
        return "The application has finished it's work! (unprintable)";
    }
}
