package org.academiadecodigo.cachealots.battlearena.fighter;

public enum FighterType {

    // TODO: 04/02/2021 add Mage to enum

    TROLL,
    GLADIATOR;

    public static FighterType getRandomType(){
        int index = (int) (Math.random() * values().length);

        return values()[index];
    }
}
