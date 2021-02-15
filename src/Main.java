public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(20, 15);
        grid.init();
        grid.generateCells();

        CellPainter painter = new CellPainter(grid);

    }
}
