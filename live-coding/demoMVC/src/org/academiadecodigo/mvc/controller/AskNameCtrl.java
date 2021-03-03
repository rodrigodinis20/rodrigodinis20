package org.academiadecodigo.mvc.controller;

import org.academiadecodigo.mvc.controller.Controller;
import org.academiadecodigo.mvc.model.Cachealot;
import org.academiadecodigo.mvc.view.View;

public class AskNameCtrl implements Controller {
    private View view;
    private Controller nextCtrl;

    @Override
    public void init() {
        view.show();
        nextCtrl.init();
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    public void createWhale(String name) {
        new Cachealot(name);
    }

    public void setNextCtrl(Controller controller) {
        this.nextCtrl = controller;
    }
}
