package org.academiadecodigo.cachealots.battlearena.fighter;

public class Troll extends Fighter {

    public Troll(){
        super(20, 5, 300);
    }

    @Override
    public void castSpell(Fighter target){
        int chance = (int) (Math.random() * 10);

        if(chance < 2){
            super.castSpell(target);
            return;
        }

        System.out.println("Troll is too sleepy to comply");
    }

    @Override
    public void strike(Fighter target){
        int chance = (int) (Math.random() * 10);

        if(chance < 3) {
            super.strike(target);
            return;
        }

        System.out.println("Troll is too sleepy to comply");
    }
}
