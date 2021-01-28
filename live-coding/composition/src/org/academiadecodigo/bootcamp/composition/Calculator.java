package org.academiadecodigo.bootcamp.composition;

public class Calculator {

    private Display display;
    private Brain brain;

    public Calculator(Display display, Brain brain){

        this.display = display;
        this.brain = brain;
    }

    public void addInt(int number1, int number2){

        int result = brain.add(number1, number2);
        display.showResult(result);
    }

    public void add(double number1, double number2){

        double result = brain.add(number1, number2);
        display.showResult(result);
    }
}
