package by.epam.composite.application.action;

import by.epam.composite.application.exception.StopApplicationException;

public interface Action {
    String description();

    void action() throws StopApplicationException;
}
