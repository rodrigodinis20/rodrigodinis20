import java.util.Iterator;

public class IntegerRange implements Iterable <Integer> {

    private Integer lowerNumber;
    private Integer higherNumber;
    private boolean reverse = true;


    public IntegerRange(Integer lowerNumber, Integer higherNumber){
        this.lowerNumber = lowerNumber;
        this.higherNumber = higherNumber;

    }


    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();

    }


    public class RangeIterator implements Iterator<Integer> {

        private int counter = reverse ? higherNumber + 1 : lowerNumber - 1;


        @Override
        public boolean hasNext() {
            reverse = true ? counter > lowerNumber : counter < higherNumber;

            /*if (reverse == true)  {
                return counter > lowerNumber;

            }
            return counter < higherNumber;

             */
            return reverse;
        }


        @Override
        public Integer next() {
            if(reverse == true) {
                return --counter;
            }
            return ++counter;

        }
    }

    /*public class RangeIteratorReverse implements Iterator<Integer> {

        private int counter = higherNumber + 1;

        @Override
        public boolean hasNext() {
            return counter > lowerNumber;

        }

        @Override
        public Integer next() {
            return --counter;

        }
    }

     */
}
