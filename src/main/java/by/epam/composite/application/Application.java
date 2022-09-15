package by.epam.composite.application;

import by.epam.composite.application.action.Action;
import by.epam.composite.application.action.StageActionFactory;
import by.epam.composite.application.exception.StopApplicationException;
import by.epam.composite.application.exception.WrongValueException;
import by.epam.composite.application.util.Input;

import static java.lang.System.out;

public class Application {

    private static final StageActionFactory stageFactory
            = StageActionFactory.getInstance();

    public static void startEntertainment() {
        out.println("Welcome! Entertainment has become!");
        actionStages();
    }

    private static void actionStages() {
        while (true) try {
            getActionStage().action();
        } catch (StopApplicationException e) {
            break;
        }
    }

    private static Action getActionStage() {
        stageFactory.showStageMenu();
        int index = Input.anyIntInitialize();
        try {
            return stageFactory.getActionStage(index);
        } catch (WrongValueException e) {
            out.println(e.getMessage());
        }
        return getActionStage();
    }
}
