package org.academiadecodigo.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.mvc.Question;
import org.academiadecodigo.mvc.controller.AskNameCtrl;
import org.academiadecodigo.mvc.view.View;

public class AskNameView implements View {
    private Prompt prompt;
    private Question question;
    private AskNameCtrl askNameCtrl;

    public AskNameView(Prompt prompt) {
        this.prompt = prompt;
        this.question = new Question();
    }

    @Override
    public void show() {
        String name = prompt.getUserInput(question.nameQuestion);
        askNameCtrl.createWhale(name);
    }

    public void setAskNameCtrl(AskNameCtrl askNameCtrl) {
        this.askNameCtrl = askNameCtrl;
    }
}
