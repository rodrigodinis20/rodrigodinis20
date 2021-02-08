package org.academiadecodigo.cachelots;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class CachealotKeyboardHandler implements KeyboardHandler {

    private Cachealot cache;


    public CachealotKeyboardHandler(Cachealot cache) {
        this.cache = cache;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                System.out.println("RIGHT");
                break;
            case KeyboardEvent.KEY_LEFT:
                System.out.println("LEFT");
                break;
            case KeyboardEvent.KEY_SPACE:
                cache.setMoving(!cache.isMoving());
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
