package vendingmachine.domain.moneymanager;

public interface MoneyManager {

    MoneyBox makeMoneyBox(int totalAmount);

    void saveInputAmount(MoneyBox moneyBox, InputAmount inputAmount);

}
