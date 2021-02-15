import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell extends Rectangle{

    private Rectangle rectangle;
    private Grid grid;
    private int col;
    private int row;

    public Cell(int col, int row, Color color, Grid grid) {
        this.row = row;
        this.col = col;
        this.grid = grid;
        rectangle = new Rectangle(grid.colsToX(col), grid.rowToY(row), Grid.getCellSize(), Grid.getCellSize());
        rectangle.setColor(color);
        rectangle.draw();

    }
}
