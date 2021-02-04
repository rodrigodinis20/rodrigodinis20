package org.academiadecodigo.cachelots;

import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class CachealotMouseHandler implements MouseHandler {
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(("x: " + mouseEvent.getX() + " y: " + mouseEvent.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
