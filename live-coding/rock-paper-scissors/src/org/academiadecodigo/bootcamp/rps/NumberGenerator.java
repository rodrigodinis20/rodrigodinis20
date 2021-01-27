package org.academiadecodigo.bootcamp.rps;

public class NumberGenerator {

    public static int randomBetween(int min , int max){
        return( int) Math.round(Math.random()*(max-min)+min);
    }
}
