package org.academiadecodigo.cachealots.battlearena.fighter;

public class FighterFactory {

    // TODO: 04/02/2021 add a way to also return a Mage instance

    public static Fighter createNewFighter(){

        FighterType type = FighterType.getRandomType();

        switch (type){

            case GLADIATOR:
                return new Gladiator();
            default:
                return new Troll();
        }
    }
}
