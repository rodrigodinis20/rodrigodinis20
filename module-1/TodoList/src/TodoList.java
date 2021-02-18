import java.util.Iterator;
import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<TodoItem> list;

    public TodoList() {
        this.list = new PriorityQueue<>();

    }

    public class TodoItem implements Comparable<TodoItem>{

        private Importance importance;
        private int priority;
        private String message;

        @Override
        public String toString() {
            return "TodoList{" +
                "importance = " + importance +
                ", priority = " + priority +
                ", item = '" + message + "\'" +
                '}';
        }



        public TodoItem(Importance importance, int priority, String message) {
            this.importance = importance;
            this.priority = priority;
            this.message = message;


        }

        @Override
        public int compareTo(TodoItem o) {
            if(this.importance.compareTo(o.importance) == 0) {
                return priority - o.priority;
                /*if(this.priority > o.priority){
                    return 1;

                }
                else if(this.priority == o.priority) {
                    return 0;

                }
                else if(this.priority < o.priority) {
                    return -1;

                }
                return 0;

                 */
                // eventually return
            }
            return importance.compareTo(o.importance);

        }
    }



    public void add(Importance importance, int priority, String message) {
        list.offer(new TodoItem(importance, priority, message));

    }

    public TodoItem remove() {
        return list.poll();

    }

    public boolean isEmpty() {
        return list.isEmpty();

    }

    public enum Importance {
        HIGH,
        MEDIUM,
        LOW

    }

}
