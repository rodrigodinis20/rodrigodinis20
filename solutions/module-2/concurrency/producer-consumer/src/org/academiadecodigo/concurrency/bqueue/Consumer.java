package org.academiadecodigo.concurrency.bqueue;

public class Consumer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementsToConsume;

    public Consumer(BQueue queue, int elementsToConsume) {
        this.queue = queue;
        this.elementsToConsume = elementsToConsume;
    }

    @Override
    public void run() {

        while (elementsToConsume > 0) {

            synchronized (queue) {

                // Block until element is removed from queue
                int elem = queue.poll();

                System.out.println("Thread " + Thread.currentThread().getName() + " has consumed element " + elem + " from the queue");

                if (queue.getSize() == 0) {
                    System.out.println(Thread.currentThread().getName() + " has left the queue empty");
                }

            }

            --elementsToConsume;

            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                // thread.interrupt called, no handling needed
            }

        }

    }
}
