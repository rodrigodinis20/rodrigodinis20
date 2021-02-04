package org.academiadecodigo.carcrash.cars;

public class Mustang extends Car{

    private int speed;

    public Mustang(int speed){
        this.speed = speed;

    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString(){
        return "M";
    }

}
