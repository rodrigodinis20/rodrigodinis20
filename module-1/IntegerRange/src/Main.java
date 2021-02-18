import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        IntegerRange range = new IntegerRange(1, 20);

        Iterator it = range.iterator();

        /*while (it.hasNext()) {
            System.out.println(it.next());

        }

         */


        for (Integer i : range) {
            System.out.println(i);
        }
    }
}
