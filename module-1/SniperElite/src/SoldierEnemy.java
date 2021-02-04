public class SoldierEnemy extends Enemy {

    public SoldierEnemy(int health){
        super(100, "Enemy soldier");

    }

    @Override
    public void hit(int damage) {
        super.hit(25);

    }
}
