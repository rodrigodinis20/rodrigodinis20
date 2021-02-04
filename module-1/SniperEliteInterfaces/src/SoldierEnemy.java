public class SoldierEnemy extends Enemy {

    public SoldierEnemy(int health){
        super(100);

    }

    @Override
    public void hit(int damage) {
        super.hit(25);

    }
}
