package Testes.Teste;

import Testes.Teste.DrinkType;

public class Sandbox {

    public static void main(String[] args){

        DrinkType currentDrink = DrinkType.BEER;

        currentDrink.drink();

        /*switch(currentDrink) {

            case BEER:
                System.out.println("Beer.");
                break;

            case HONEYMEAD:
                System.out.println("Honeymead.");
                break;

            case GIN_TONIC:
                System.out.println("Gin tonic");
                break;
        }*/
    }
}
