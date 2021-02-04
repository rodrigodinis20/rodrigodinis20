package org.academiadecodigo.cachealots.battlearena;

import org.academiadecodigo.cachealots.battlearena.fighter.Fighter;
import org.academiadecodigo.cachealots.battlearena.fighter.FighterFactory;

public class Player {

    // TODO: 04/02/2021 implement a way to check if the player has fighters alive to keep playing

    private Fighter[] fighters;

    public Player() {
        createFighters();
    }

    private void createFighters() {

        fighters = new Fighter[3];

        for (int i = 0; i < fighters.length; i++) {
            fighters[i] = FighterFactory.createNewFighter();
        }
    }

    public void attack(Player opponent) {

        int attackingIndex = (int) (Math.random() * fighters.length);
        Fighter attacker = this.fighters[attackingIndex];

        int defendingIndex = (int) (Math.random() * opponent.fighters.length);
        Fighter target = opponent.fighters[defendingIndex];

        System.out.println("Attacker: " + attacker.getClass().getSimpleName());
        System.out.println("Defender: " + target.getClass().getSimpleName());

        attacker.attack(target);
    }
}
