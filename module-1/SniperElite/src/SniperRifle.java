public class SniperRifle {

    private int bulletDamage;

    public SniperRifle(int bulletDamage){
        this.bulletDamage = bulletDamage;


    }

    public int bulletDamage() {
        return this.bulletDamage;
    }

    //int damage = (int) Math.ceil(Math.random() * 100);

    public void shoot(Enemy enemy) {
        System.out.println("You hit the " + enemy.getClass().getSimpleName() + " for " + bulletDamage() + " damage!");
        enemy.hit(bulletDamage);

    }

}
