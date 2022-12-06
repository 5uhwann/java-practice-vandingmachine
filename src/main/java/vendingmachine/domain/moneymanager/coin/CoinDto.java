package vendingmachine.domain.moneymanager.coin;

import static vendingmachine.domain.moneymanager.coin.Coin.*;

import java.util.List;

public class CoinDto {

    private static final String PREFIX_FIRST = "자판기가 보유한 동전";
    private static final String PREFIX_LAST = "개";

    private final List<Coin> coins;

    public CoinDto(List<Coin> coins) {
        this.coins = coins;
    }



    public String toString() {
        return  PREFIX_FIRST + "\n" +
                COIN_500.getKoreanTag() + countCoin(coins, COIN_500) + PREFIX_LAST + "\n" +
                COIN_100.getKoreanTag() + countCoin(coins, COIN_100) + PREFIX_LAST + "\n" +
                COIN_50.getKoreanTag() + countCoin(coins, COIN_50) + PREFIX_LAST + "\n" +
                COIN_10.getKoreanTag() + countCoin(coins, COIN_10) + PREFIX_LAST;

    }

    private String countCoin(List<Coin> coins, Coin coinType) {
        int count = 0;
        for (Coin coin : coins) {
            if (coin.equals(coinType)) {
                count++;
            }
        }

        return String.valueOf(count);
    }
}
