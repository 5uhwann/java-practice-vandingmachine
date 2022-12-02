package vendingmachine.domain.moneymanager;

public class InputAmount {

    private static final int MIN_AMOUNT = 10;
    private static final int MAX_AMOUNT = 10_000;

    private final int inputAmount;

    public InputAmount(int inputAmount) {
        validateInputAmount(inputAmount);
        this.inputAmount = inputAmount;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount < MIN_AMOUNT || inputAmount > MAX_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 금액 투입은 10원부터 10000원까지 가능합니다.");
        }
        if (inputAmount % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 투입 금액은 10원단위의 금액이어야 합니다.");
        }
    }
}
