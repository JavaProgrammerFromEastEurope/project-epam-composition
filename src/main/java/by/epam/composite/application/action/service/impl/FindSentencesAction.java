package by.epam.composite.application.action.service.impl;

import by.epam.composite.application.action.Action;
import by.epam.composite.application.action.service.BaseStageAction;

public class FindSentencesAction extends BaseStageAction implements Action {

    @Override
    public String description() {
        return "Find sentences with the longest word\n";
    }

    @Override
    public void action() {
        serviceActions.findSentencesAction();
    }
}
