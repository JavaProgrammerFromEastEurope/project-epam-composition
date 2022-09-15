package by.epam.composite.application.action.service.impl;

import by.epam.composite.application.action.Action;
import by.epam.composite.application.action.service.BaseStageAction;

public class FindTheSameWordsAction extends BaseStageAction implements Action {

    @Override
    public String description() {
        return "Find in the text all the same words " +
                "\n\twithout case sensitivity and count their number\n";
    }

    @Override
    public void action() {
        serviceActions.findTheSameWordsAction();
    }
}
