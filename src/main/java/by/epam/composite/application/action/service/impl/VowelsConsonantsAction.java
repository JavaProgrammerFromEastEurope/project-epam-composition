package by.epam.composite.application.action.service.impl;

import by.epam.composite.application.action.Action;
import by.epam.composite.application.action.service.BaseStageAction;

public class VowelsConsonantsAction extends BaseStageAction implements Action {

    @Override
    public String description() {
        return "Count the number of vowels and consonants in a sentence\n";
    }

    @Override
    public void action() {
        serviceActions.vowelsConsonantsAction();
    }
}
