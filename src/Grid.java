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

    }
}
