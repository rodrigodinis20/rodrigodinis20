package org.academiadecodigo.carcrash.cars;

import com.googlecode.lanterna.terminal.Terminal;

public class Fiat extends Car{

    private int speed;
    public Fiat(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString(){
        return "F";
    }
}
