package org.academiadecodigo.mvc;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.mvc.controller.AskNameCtrl;
import org.academiadecodigo.mvc.controller.Controller;
import org.academiadecodigo.mvc.controller.IntroController;
import org.academiadecodigo.mvc.controller.WelcomeCtrl;
import org.academiadecodigo.mvc.view.AskNameView;
import org.academiadecodigo.mvc.view.IntroView;
import org.academiadecodigo.mvc.view.View;
import org.academiadecodigo.mvc.view.WelcomeView;

public class App {
    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in,System.out);

        IntroController introCtrl = new IntroController();
        View introView = new IntroView(prompt);

        AskNameCtrl askNameCtrl = new AskNameCtrl();
        AskNameView askNameView = new AskNameView(prompt);

        WelcomeCtrl welcomeCtrl = new WelcomeCtrl();
        WelcomeView welcomeView = new WelcomeView();

        introCtrl.setView(introView);
        introCtrl.setNextCtrl(askNameCtrl);

        askNameCtrl.setView(askNameView);
        askNameCtrl.setNextCtrl(welcomeCtrl);
        askNameView.setAskNameCtrl(askNameCtrl);

        welcomeCtrl.setView(welcomeView);

        introCtrl.init();


    }
}
