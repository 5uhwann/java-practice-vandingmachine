package vendingmachine.domain.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {

    private static final CalculatorImpl calculator = new CalculatorImpl();

    @Test
    void calculateTest() {
        //given
        int inputAmount = 4000;
        int subtractedPrice = 1500;

        //when
        int calculatedAmount = calculator.calculate(inputAmount, subtractedPrice);

        //then
        Assertions.assertThat(calculatedAmount).isEqualTo(inputAmount - subtractedPrice);
    }

}
