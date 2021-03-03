package org.academiadecodigo.mvc.controller;

import org.academiadecodigo.mvc.view.View;

public interface Controller {
    void init();
    void setView(View view);
}
