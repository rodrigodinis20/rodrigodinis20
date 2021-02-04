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
            int create = (int) Math.ceil(Math.random() * 4);
            if (create > 3) {
                gameObjects[i] = new ArmouredEnemy(100, 50);
                System.out.println("armored");

            } else if (create < 3) {
                gameObjects[i] = new SoldierEnemy(100);
                System.out.println("soldier");
            } else {
                gameObjects[i] = new Tree();
                System.out.println("tree");
            }
        }
    }

    private void shoot() {
        for (int i = 0; i < gameObjects.length; i++) {

            if (gameObjects[i] instanceof Enemy) {
                while (((Enemy) gameObjects[i]).isDead() == false) {
                    shotsFired++;
                    System.out.println("You have shot " + this.shotsFired + " rounds");
                    sniperRifle.shoot((Enemy) gameObjects[i]);

                }
            }
        }
    }
}
