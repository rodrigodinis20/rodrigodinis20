import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell extends Rectangle{

    private Grid grid;
    private int col;
    private int row;
    private boolean painted;

    public Cell(int col, int row, Grid grid) {
        super(grid.colsToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        this.row = row;
        this.col = col;
        this.grid = grid;
        draw();

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Rectangle getRectangle() {
        return this;
    }

    public void updateRowDown() {
        row ++;
    }

    public void updateRowUp() {
        row --;
    }

    public void updateColRight() {
        col ++;
    }

    public void updateColLeft() {
        col --;
    }

    public boolean isPainted() {
        return painted;
    }
}
