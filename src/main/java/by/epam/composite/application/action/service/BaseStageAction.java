package by.epam.composite.application.action.service;

import by.epam.composite.application.action.StageActionFactory;
import by.epam.composite.controller.impl.TextController;

public abstract class BaseStageAction {

    protected final TextController serviceActions;
    protected final StageActionFactory stageFactory;

    public BaseStageAction() {
        this.serviceActions = new TextController();
        this.stageFactory = StageActionFactory.getInstance();
    }
}
