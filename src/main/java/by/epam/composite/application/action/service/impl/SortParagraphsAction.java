package by.epam.composite.application.action.service.impl;

import by.epam.composite.application.action.Action;
import by.epam.composite.application.action.service.BaseStageAction;

public class SortParagraphsAction extends BaseStageAction implements Action {

    @Override
    public String description() {
        return "Sort paragraphs by number of sentences\n";
    }

    @Override
    public void action() {
        serviceActions.sortParagraphsAction();
    }
}
