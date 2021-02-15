import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class CellPainter extends Cell implements KeyboardHandler {


    private Grid grid;
    private boolean canPaint = true;
    private Keyboard keyboard;


    public CellPainter(Grid grid) {
        super(0, 0, Color.GREEN, grid);
        this.grid = grid;
        keyboard = new Keyboard(this);
        setColor(Color.GREEN);
        fill();

        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

    }


    public void moveUp(Cell cell) {
        if (cell.getRow() == 0) return;
        cell.getRectangle().translate(0, -grid.getCellSize());
        updateRowUp();

    }

    public void moveDown(Cell cell) {
        if (cell.getRow() == grid.getHeight()) return;
        cell.getRectangle().translate(0, grid.getCellSize());
        updateRowDown();

    }

    public void moveRight(Cell cell) {
        if (cell.getCol() == grid.getWidth()) return;
        cell.getRectangle().translate(grid.getCellSize(), 0);
        updateColRight();

    }

    public void moveLeft(Cell cell) {
        if (cell.getCol() == 0) return;
        cell.getRectangle().translate(-grid.getCellSize(), 0);
        updateColLeft();
    }

    public void fillCell() {

        grid.getCells()[getCol()][getRow()].setColor(Color.GREEN);
        if (!grid.getCells()[getCol()][getRow()].isFilled()) {
            grid.getCells()[getCol()][getRow()].fill();

        }
        else {grid.getCells()[getCol()][getRow()].draw();
        grid.getCells()[getCol()][getRow()].setColor(Color.BLACK);
        }


    }

    public void setCanPaint(boolean canPaint) {
        this.canPaint = canPaint;
    }

    public boolean isCanPaint() {
        return canPaint;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                moveUp(this);
                break;

            case KeyboardEvent.KEY_DOWN:
                moveDown(this);
                break;

            case KeyboardEvent.KEY_LEFT:
                moveLeft(this);
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight(this);
                break;
            case KeyboardEvent.KEY_SPACE:
                fillCell();
                setCanPaint(false);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
