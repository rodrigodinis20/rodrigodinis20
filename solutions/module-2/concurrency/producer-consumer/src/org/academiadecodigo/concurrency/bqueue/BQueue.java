package org.academiadecodigo.concurrency.bqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Blocking queue
 */
public class BQueue<T> {

    /**
     * Queue size
     **/
    final private int limit;

    /**
     * Container backing up the queue
     */
    final private Queue<T> list;

    /**
     * @param limit the queue size
     */
    public BQueue(int limit) {
        this.limit = limit;
        list = new LinkedList<>();
    }

    /**
     * Adds an item into the queue, blocking if the queue is full
     *
     * @param i the item to add
     */
    public void offer(T i) {

        synchronized (this) {

            // Make sure we block when the queue is full, even if interrupted
            while (list.size() == limit) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // thread.interrupt called, no handling needed
                }
            }

            // Add element to the queue
            list.offer(i);
            System.out.println("## ELEMENT ADDED, SIZE OF QUEUE IS NOW " + list.size() + " ##");

            // Notify other threads
            notifyAll();

        }

    }

    /**
     * Removes an item from the queue, blocking if the queue is empty
     *
     * @return the removed item
     */
    public T poll() {

        synchronized (this) {

            // Make sure we block when the queue is empty, even if interrupted
            while (list.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // thread.interrupt called, no handling needed
                }
            }

            // Remove item from the queue
            T value = list.poll();
            System.out.println("## ELEMENT REMOVED, SIZE OF QUEUE IS NOW " + list.size() + " ##");

            // Notify other threads
            notifyAll();

            return value;

        }

    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {
        synchronized (this) {
            return list.size();
        }
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;
    }
}
