package org.academiadecodigo.cachelots;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CachealotKeyboardHandler implements KeyboardHandler {

    private Picture cache;

    public CachealotKeyboardHandler(Picture cache){
        this.cache = cache;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                cache.translate(Test.CELL_SIZE,0);
                System.out.println("RIGHT");
                break;
            case KeyboardEvent.KEY_LEFT:
                System.out.println("LEFT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
