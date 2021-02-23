package org.academiadecodigo.cachelots;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 100;
    private static final int BAR_WIDTH = 10 * CELL_SIZE;


    public static void main(String[] args) throws InterruptedException {

        Rectangle bar = new Rectangle(PADDING, PADDING, BAR_WIDTH, CELL_SIZE);
        bar.setColor(Color.LIGHT_GRAY);
        bar.fill();

        Cachealot cachealot = new Cachealot();


        //implement KeyboardHandler
        CachealotKeyboardHandler handler = new CachealotKeyboardHandler(cachealot);

        //instanciate keyboard
        Keyboard keyboard = new Keyboard(handler);

        //add events - type + key (int)

        //one way
        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_RIGHT);
        e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(e);

        //other way
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

        //Mouse
        CachealotMouseHandler mouseHandler = new CachealotMouseHandler();
        Mouse remi = new Mouse(mouseHandler);

        remi.addEventListener(MouseEventType.MOUSE_CLICKED);
        remi.addEventListener(MouseEventType.MOUSE_MOVED);

        while (true){
            Thread.sleep(10);
            cachealot.move();
        }

    }

}
