public class Field {

    private Board board;
    private int col;
    private int row;
    private boolean isAvailable;

    public Field(int col, int row, Board board) {
        this.col = col;
        this.row = row;
        this.board = board;
        isAvailable = false;

    }

    public boolean isAvailable() {
        return isAvailable;
    }



    public int getCol() {
        return col;

    }

    public int getRow() {
        return row;
    }

}

