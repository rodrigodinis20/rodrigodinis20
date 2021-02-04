package org.academiadecodigo.cachealots.battlearena.fighter;

public abstract class Fighter {

    private int attackDamage;
    private int spellDamage;
    private int health;

    public Fighter(int attackDamage, int spellDamage, int health){

        this.attackDamage = attackDamage;
        this.spellDamage = spellDamage;
        this.health = health;
    }

    /* Added randomness to type of attack directly to fighter class */
    public void attack(Fighter target){
        int random = (int) (Math.random() * 10);

        if(isDead()){
            System.out.println("I'm ded");
            return;
        }

        if (random < 5) {
            castSpell(target);
            return;
        }

        strike(target);
    }

    /* Changed access modifier from public to protected, only subclasses need to have access here */
    protected void castSpell(Fighter target){

        target.getHit(spellDamage);
    }

    protected void strike(Fighter target){

        target.getHit(attackDamage);
    }

    protected void getHit(int damage){

        health -= damage;
    }

    public boolean isDead(){
        return health <= 0;
    }
}
