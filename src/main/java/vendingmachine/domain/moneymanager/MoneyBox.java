package vendingmachine.domain.moneymanager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoneyBox {

    private final List<Coin> coins;
    private final int totalAmount;
    private int inputAmount;

    public MoneyBox(List<Coin> coins) {
        this.coins = coins;
        this.totalAmount = initTotalAmount(coins);
    }

    private int initTotalAmount(List<Coin> coins) {
        int totalAmount = 0;
        for (Coin coin : coins) {
            totalAmount += coin.getAmount();
        }
        return totalAmount;
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

    public List<Coin> withdrawCoin(int change) {
        if (change > totalAmount) {
            return coins;
        }
        return calculateCoin(change);
    }

    private List<Coin> calculateCoin(int change) {
        List<Coin> changeCoins = new ArrayList<>();
        List<Coin> copiedCoins = copyCoin();
        copiedCoins.sort(Comparator.comparingInt(Coin::getAmount).reversed());

        for (Coin coin : copiedCoins) {
            if (change >= coin.getAmount()) {
                changeCoins.add(coin);
                change -= coin.getAmount();
            }
        }

        if (change != 0) {
            throw new IllegalArgumentException("보유 동전이 부족합니다 관리제에게 문의 하세요");
        }
        return changeCoins;
    }

    private List<Coin> copyCoin() {
        return new ArrayList<>(coins);
    }
}
