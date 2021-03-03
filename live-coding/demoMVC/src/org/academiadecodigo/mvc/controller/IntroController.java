package org.academiadecodigo.mvc.controller;

import org.academiadecodigo.mvc.view.View;

public class IntroController implements Controller {

    private View introView;
    private Controller nextCtrl;

    @Override
    public void init() {
        introView.show();
        nextCtrl.init();

    }

    public void setView(View introView) {
        this.introView = introView;
    }

    public void setNextCtrl(Controller ctrl){
        this.nextCtrl = ctrl;
    }
}
