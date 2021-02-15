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
        grid.setColor(Color.BLACK);

    }

    public void init() {
        grid.draw();

    }
    public void generateCells(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[j].length; j++) {
                cells[i][j] = new Cell(i, j, Color.BLACK, this);

            }
        }
    }

    public static int getPADDING() {
        return PADDING;

    }

    public int rowToY(int row) {
        return PADDING + (row * CELL_SIZE);

    }

    public int colsToX(int col) {
        return PADDING + (col * CELL_SIZE);

    }

    public int getY() {
        return grid.getY();
    }

    public int getX() {
        return grid.getX();
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }
}
