import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final static int PADDING = 10;
    private final static int CELL_SIZE = 20;
    private int cols;
    private int rows;
    private Rectangle grid;


    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;

        grid = new Rectangle(PADDING, PADDING, CELL_SIZE, CELL_SIZE);
        grid.setColor(Color.BLACK);

    }

    public void init() {
        grid.draw();

    }
    public void generateCells(){
        int padding2 = PADDING;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                new Cell(padding2, PADDING + (CELL_SIZE * j), CELL_SIZE, CELL_SIZE, Color.BLACK);

            }
            padding2 += CELL_SIZE;

        }
    }
}
