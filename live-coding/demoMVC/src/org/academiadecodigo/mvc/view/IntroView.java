package org.academiadecodigo.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.mvc.Question;

public class IntroView implements View {

    private Prompt prompt;
    private Question question;

    public IntroView(Prompt prompt) {
        this.prompt = prompt;
        this.question = new Question();
    }

    @Override
    public void show() {
        int option = prompt.getUserInput(question.getJoinTeam());
        if(option == 2){
            System.out.println("KTHXBYE");
            System.exit(1);
        }


    }
}
