import java.awt.event.WindowStateListener;

public class Game {

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFired;


    public void setShotsFired() {
        this.shotsFired = shotsFired;
    }

    public void start() {

        createObjects();

        shoot();
    }

    public Game(int size) {
        this.gameObjects = new GameObject[size];
        sniperRifle = new SniperRifle(25);

    }


    public void createObjects() {
        for (int i = 0; i < gameObjects.length; i++) {
            int create = (int) Math.ceil(Math.random() * 10);
            if (create > 8) {
                gameObjects[i] = new ArmouredEnemy(100, 50);
                System.out.println("armored");

            } else if (create > 5 && create <= 8) {
                gameObjects[i] = new SoldierEnemy(100);
                System.out.println("soldier");

            } else if (create < 3) {
                gameObjects[i] = new Tree();
                System.out.println("tree");

            } else {
                gameObjects[i] = new Barrel();
                System.out.println(gameObjects.toString());

            }
        }
    }

    private void shoot() {
        for (int i = 0; i < gameObjects.length; i++) {

            if (gameObjects[i] instanceof Destroyable) {
                while (((Destroyable) gameObjects[i]).isDestroyed() == false) {
                    shotsFired++;
                    System.out.println("You have shot " + this.shotsFired + " rounds");
                    sniperRifle.shoot((Destroyable) gameObjects[i]);

                }
            }
        }
    }
}
