package vendingmachine.domain.moneymanager;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MoneyManagerImpl implements MoneyManager {

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
       return new MoneyBox(coins);
    }
}
