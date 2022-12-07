package vendingmachine.domain.moneymanager.inputamount;

public class InputAmountDto {

    private static final String PREFIX_FIRST = "투입 금액: ";
    private static final String PREFIX_LAST = "원";

    private final InputAmount inputAmount;

    public InputAmountDto(InputAmount inputAmount) {
        this.inputAmount = inputAmount;
    }

    public String toString() {
        return PREFIX_FIRST + inputAmount.getInputAmount() + PREFIX_LAST;
    }
}
