package calculator;

public class Calculator {

    public int sum(int n1, int n2) {
        if (n1 < 0 || n2 < 0 ) {
            throw new IllegalArgumentException();
        }
        return n1 + n2;

    }
}
