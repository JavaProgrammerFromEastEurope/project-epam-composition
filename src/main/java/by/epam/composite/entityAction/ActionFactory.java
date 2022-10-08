package by.epam.composite.entityAction;

import by.epam.composite.entityAction.impl.TextActions;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private static final ActionFactory instance = new ActionFactory();

    private final Map<Integer, ActionTemplate> appActions = new HashMap<>();

    public static ActionFactory getInstance() {
        return instance;
    }

    private ActionFactory() {
        appActions.put(1, new TextActions());
    }

    public ActionTemplate getTextActions() {
        return appActions.get(1);
    }
}
