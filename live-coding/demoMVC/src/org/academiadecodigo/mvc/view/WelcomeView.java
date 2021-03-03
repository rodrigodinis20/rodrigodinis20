package org.academiadecodigo.mvc.view;

import org.academiadecodigo.mvc.Message;

public class WelcomeView implements View {
    @Override
    public void show() {
        System.out.println(Message.caches);
    }
}
