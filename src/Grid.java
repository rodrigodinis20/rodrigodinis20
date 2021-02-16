import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Cell[][] cells;
    private final static int PADDING = 10;
    private final static int CELL_SIZE = 20;
    private int cols;
    private int rows;
    private Rectangle grid;


    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        cells = new Cell[cols][rows];
        grid = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);

    }

    public void init() {
        grid.draw();

    }

    public void generateCells(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[j].length; j++) {
                cells[i][j] = new Cell(i, j, this);

            }
        }
    }

    public void clearCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[j].length; j++) {
                //cells[i][j].delete();
                cells[i][j].draw();
            }
        }
    }

    public int rowToY(int row) {
        return PADDING + (row * CELL_SIZE);

    }

    public int colsToX(int col) {
        return PADDING + (col * CELL_SIZE);

    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public int getHeight() {
        return rows-1;
    }

    public int getWidth() {
        return cols-1;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
