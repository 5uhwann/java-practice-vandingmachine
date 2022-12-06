package vendingmachine.domain.moneymanager;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.moneymanager.coin.Coin;
import vendingmachine.domain.moneymanager.coin.CoinDto;

public class MoneyManagerImpl implements MoneyManager {

    private MoneyBox moneyBox;

    @Override
    public MoneyBox makeMoneyBox(int totalAmount) {
        int remainderAmount = totalAmount;
        List<Coin> coins = new ArrayList<>();
        while (remainderAmount != 0) {
            Coin coin = Coin.values()[Randoms.pickNumberInRange(0, 3)];
            if (coin.isAbleCoin(remainderAmount)) {
                coins.add(coin);
                remainderAmount -= coin.getAmount();
            }
        }
        moneyBox = new MoneyBox(coins);
        return moneyBox;
    }

    @Override
    public void saveInputAmount(InputAmount inputAmount) {
        moneyBox.setInputAmount(inputAmount.getInputAmount());
    }

    @Override
    public void updateInputAmount(int updatedInputAmount) {
        moneyBox.setInputAmount(updatedInputAmount);
    }

    @Override
    public List<Coin> payChangeCoin(int change) {
        return moneyBox.withdrawCoin(change);
    }

    @Override
    public CoinDto inquiryCoins() {
        return new CoinDto(moneyBox.getCoins());
    }
}
