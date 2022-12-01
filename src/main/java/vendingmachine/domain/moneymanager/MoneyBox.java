package vendingmachine.domain.moneymanager;

import java.util.List;

public class MoneyBox {

    private List<Coin> coins;

    public MoneyBox(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getCoins() {
        return coins;
    }
}
