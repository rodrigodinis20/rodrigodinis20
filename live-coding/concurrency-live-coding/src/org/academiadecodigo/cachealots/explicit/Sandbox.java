package org.academiadecodigo.cachealots.explicit;

public class Sandbox {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        myTask.run();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyTask());
            thread.setName("T - " + i);
            thread.start();
        }

        Thread randomThread =  new Thread(myTask);
        randomThread.start();
    }
}
