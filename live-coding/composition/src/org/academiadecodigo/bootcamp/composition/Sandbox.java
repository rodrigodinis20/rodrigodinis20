package org.academiadecodigo.bootcamp.composition;

public class Sandbox {

    public static void main (String[] args){

        Calculator calc = new Calculator(new Display(), new Brain());

        calc.add(35.567, 34);
        calc.add(34, 35.34);
    }
}
