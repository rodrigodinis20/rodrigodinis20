package org.academiadecodigo.carcrash.field;

import com.googlecode.lanterna.terminal.Terminal;

public class Position {

    private int col;
    private int row;

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void goUp() {
        this.row--;
    }

    public void goDown() {
        this.row++;
    }

    public void goRight() {
        this.col++;
    }

    public void goLeft() {
        this.col--;
    }

    public Position(){
        this.col = (int) (Math.random() * Field.getWidth());
        //System.out.println("col is: " + col);
        this.row = (int) (Math.random() * Field.getHeight());
        //System.out.println("row is: " + row);
    }

}
