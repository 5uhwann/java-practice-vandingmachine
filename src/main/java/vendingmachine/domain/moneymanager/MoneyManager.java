package vendingmachine.domain.moneymanager;

import java.util.List;
import vendingmachine.domain.moneymanager.coin.Coin;
import vendingmachine.domain.moneymanager.coin.CoinDto;
import vendingmachine.domain.moneymanager.inputamount.InputAmount;

public interface MoneyManager {

    MoneyBox makeMoneyBox(int totalAmount);

    void saveInputAmount(InputAmount inputAmount);

    void updateInputAmount(int updatedInputAmount);

    List<Coin> payChangeCoin(int change);

    CoinDto inquiryCoins();

}
