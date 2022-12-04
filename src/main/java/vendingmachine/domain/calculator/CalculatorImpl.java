package vendingmachine.domain.calculator;

public class CalculatorImpl implements Calculator{

    @Override
    public int calculate(int inputAmount, int subtractedPrice) {
        return inputAmount - subtractedPrice;
    }
}
