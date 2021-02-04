public class SniperRifle {

    private int bulletDamage;

    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;

    }

    public void shoot(Destroyable destroyable) {
        System.out.println("you shot the " + destroyable.getClass().getSimpleName());
        destroyable.hit(25);

    }

}
