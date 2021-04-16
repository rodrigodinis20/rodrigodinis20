package calculatorTest;

import calculator.Calculator;
import calculator.Display;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();

    }

    @Test
    public void sumTest() {
        int result = calculator.sum(10, 5);
        int expected = 15;

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumNegativeTest() {
        calculator.sum(-10, 10);

        when(calculator.sum(anyInt(),anyInt())).thenReturn(3);


    }


}
