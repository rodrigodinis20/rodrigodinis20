package org.academiadecodigo.cachealots.implicit;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {

    private static Timer timer;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of rings?");
        int numRings = scanner.nextInt();

        System.out.println("Ring interval in seconds?");
        int ringInterval = scanner.nextInt();

        System.out.println(Thread.currentThread().getName());

        start(ringInterval, numRings);
        System.out.println("main ended");
    }

    private static void start(int ringInterval, int numRings){

        timer = new Timer();
        timer.scheduleAtFixedRate(new Ring(numRings), 0, ringInterval * 1000);
    }

    private static void stop(){

        timer.cancel();
    }

    private static class Ring extends TimerTask {

        private int numRings;

        public Ring(int numRings) {
            this.numRings = numRings;
        }

        @Override
        public void run() {

            System.out.println("Alarm is ringing...");
            System.out.println(Thread.currentThread().getName());
            numRings--;

            if(numRings == 0){
                System.out.println("Alarm is canceled");
                stop();
            }
        }
    }
}
