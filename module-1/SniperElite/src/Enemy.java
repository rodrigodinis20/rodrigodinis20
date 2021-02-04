public abstract class Enemy extends GameObject {

    private int health;
    private boolean isDead;

    public Enemy(int health, String type){
        super("Enemy");
        this.health = health;

    }

    public boolean isDead() {
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
