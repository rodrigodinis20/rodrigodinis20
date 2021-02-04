import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {

    public static void main(String[] args) {

        //one way
        CachealotKeyboardHandler handler = new CachealotKeyboardHandler();
        Keyboard keyboard = new Keyboard(handler);
        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_RIGHT);
        e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        //other way

        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);

    }
}
