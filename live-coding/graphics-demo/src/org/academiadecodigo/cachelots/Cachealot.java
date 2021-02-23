package org.academiadecodigo.cachelots;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cachealot {

    private final Picture cache;
    private boolean isMoving;
    private double t = 0;

    private static final int WHALE_WEIGHT = 1; //100 kgV
    private static final double GRAV_CONSTANT = -9.8; //ay = m/s^2
    private static final double v0 = 12; //ay = m/s^2
    double lasty = 0;
    //var y = v0t + 1/2 ay * t^2

    public Cachealot() {

        Picture cache = new Picture(Test.PADDING, Test.PADDING * 50, "resources/cache.png");
        cache.draw();
        this.cache = cache;
    }

    public void move() {

        if (!isMoving) {
            return;
        }

        t += 0.1;
        double y = -(v0 * t + (0.5 * GRAV_CONSTANT * t * t));

        if (cache.getY() + y > 500) {

            cache.translate(0, 500 - cache.getY());
            setMoving(false);
            return;
        }

        System.out.println("d:" + getY());
        cache.translate(0, y);
        lasty = cache.getY();

    }

    public void setMoving(boolean moving) {
        t = 0;
        isMoving = moving;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public double getY() {
        return cache.getY();
    }
}
