package vendingmachine.domain.moneymanager;

import java.util.List;

public interface MoneyManager {

    MoneyBox makeMoneyBox(int totalAmount);

    void saveInputAmount(InputAmount inputAmount);

    void updateInputAmount(int updatedInputAmount);

    List<Coin> payChangeCoin(int change);

}
