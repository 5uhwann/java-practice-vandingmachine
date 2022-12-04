package vendingmachine.domain.moneymanager;

public interface MoneyManager {

    MoneyBox makeMoneyBox(int totalAmount);

    void saveInputAmount(InputAmount inputAmount);

    void updateInputAmount(int updatedInputAmount);

}
