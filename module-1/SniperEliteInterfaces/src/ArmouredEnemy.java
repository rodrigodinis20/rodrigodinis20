public class ArmouredEnemy extends Enemy {

    private int armour;

    public ArmouredEnemy(int health, int armour) {
        super(100);
        this.armour = armour;

    }

    @Override
    public void hit(int damage) {
        if(this.armour > damage){
            this.armour -= damage;
            return;
        }

        super.hit(25);
    }

}
