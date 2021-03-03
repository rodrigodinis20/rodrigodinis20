package org.academiadecodigo.mvc.controller;

import org.academiadecodigo.mvc.view.View;

public class WelcomeCtrl implements Controller{
    private View view;

    @Override
    public void init() {
        view.show();

    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
