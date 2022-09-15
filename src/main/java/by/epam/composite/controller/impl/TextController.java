package by.epam.composite.controller.impl;

import by.epam.composite.controller.ActionController;
import by.epam.composite.entityAction.ActionFactory;
import by.epam.composite.entityAction.ActionTemplate;

public class TextController implements ActionController {

    private final ActionTemplate textController;


    public TextController() {
        this.textController = ActionFactory.getInstance().getTextActions();
    }
    @Override
    public void sortParagraphsAction() {
        this.textController.sortParagraphsAction();
    }

    @Override
    public void findTheSameWordsAction() {
        this.textController.findTheSameWordsAction();
    }

    @Override
    public void removeSentencesAction() {
        this.textController.removeSentencesAction();
    }

    @Override
    public void findSentencesAction() {
        this.textController.findSentencesAction();
    }

    @Override
    public void vowelsConsonantsAction() {
        this.textController.vowelsConsonantsAction();
    }
}