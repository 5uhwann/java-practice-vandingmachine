package vendingmachine.domain.moneymanager;

import java.util.List;

public class MoneyBox {

    private List<Coin> coins;
    private int inputAmount;

    public MoneyBox(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(int inputAmount) {
        this.inputAmount = inputAmount;
    }
}
