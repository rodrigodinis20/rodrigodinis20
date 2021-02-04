package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {


    /** The position of the car on the grid */
    private Position pos;

    public Car(){
        this.pos = new Position();

    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return false;
    }

    public void moveDirection(Car cars, int direction){

        int directionMoved = (int) Math.ceil(Math.random()*4);
        //direction=1 --> move up
        if (directionMoved == 1) {
            getPos().setRow(getPos().getRow()-1);

        }
        //direction = 2 --> move down
        if (directionMoved == 2) {
            getPos().setRow(getPos().getRow()+1);
        }
        //direction = 3 --> move right
        if (directionMoved == 3) {
            getPos().setCol(getPos().getCol()+1);
        }
        //direction = 4 --> move left
        if (directionMoved == 4) {
            getPos().setCol(getPos().getCol()-1);
        }


    }
    public void hittingWall(Car cars, int direction) {
        getPos();
        if (getPos().getCol() == Field.getWidth() -Field.getWidth()) {
            getPos().goRight();

        }
        if (getPos().getCol() == Field.getWidth() - 1) {
            getPos().goLeft();
        }

        if (getPos().getRow() == Field.getHeight() - Field.getHeight()) {
            getPos().goDown();
        }

        if (getPos().getRow() == Field.getHeight() - 1) {
            getPos().goUp();
        }
    }

}
