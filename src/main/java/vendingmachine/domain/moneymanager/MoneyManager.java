package vendingmachine.domain.moneymanager;

import vendingmachine.domain.moneymanager.coin.ChangeCoinDto;
import vendingmachine.domain.moneymanager.coin.CoinDto;
import vendingmachine.domain.moneymanager.inputamount.InputAmount;
import vendingmachine.domain.moneymanager.inputamount.InputAmountDto;

public interface MoneyManager {

    MoneyBox makeMoneyBox(int totalAmount);

    void saveInputAmount(InputAmount inputAmount);

    void updateInputAmount(int updatedInputAmount);

    ChangeCoinDto payChangeCoin(int change);

    CoinDto inquiryCoins();

    InputAmountDto inquiryInputAmount();

}
