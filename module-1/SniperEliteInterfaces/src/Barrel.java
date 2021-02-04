public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel(){
        barrelType = BarrelType.values()[(int) Math.floor(Math.random()*BarrelType.values().length)];
        this.currentDamage = currentDamage;
    }

    /*public int getCurrentDamage(){
        return currentDamage;
    }

     */

    @Override
    public void hit(int bulletDamage) {
        /*while(currentDamage <= barrelType.getMaxDamage()) {
            bulletDamage += currentDamage ;

        }

         */
        if (currentDamage <= barrelType.getMaxDamage()) {
            currentDamage += bulletDamage;
            //System.out.println("The barrel has been destroyed");

        } if (currentDamage >= barrelType.getMaxDamage()) {
            destroyed = true;
            System.out.println("The barrel has been destroyed");
        }

    }

    @Override
    public boolean isDestroyed() {
        return destroyed;

    }

    @Override
    public String getMessage() {
        return "This is a barrel";
    }
}
