public abstract class Enemy extends GameObject implements Destroyable {

    private int health;
    private boolean isDead;

    public Enemy (int health){
        this.health = health;

    }

    public boolean isDead() {
        return isDead;

    }

    @Override
    public boolean isDestroyed() {
        return isDead;

    }


    public void hit(int damage){
        if(this.health >= damage) {
            this.health -= damage;

        }
        if(this.health < damage){
            isDead = true;
            System.out.println("The enemy is dead!");

        }
    }

    @Override
    public String getMessage(){
        return "You shoot an enemy!";

    }
}
