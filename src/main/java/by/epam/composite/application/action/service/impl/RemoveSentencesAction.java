package by.epam.composite.application.action.service.impl;

import by.epam.composite.application.action.Action;
import by.epam.composite.application.action.service.BaseStageAction;

public class RemoveSentencesAction extends BaseStageAction implements Action {

    @Override
    public String description() {
        return "Remove from the text all sentences with " +
                "\n\tthe number of words less than the given one\n";
    }

    @Override
    public void action() {
        serviceActions.removeSentencesAction();
    }
}
