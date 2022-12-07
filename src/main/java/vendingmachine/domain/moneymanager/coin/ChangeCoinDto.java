package vendingmachine.domain.moneymanager.coin;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeCoinDto {

    private static final String PREFIX_FIRST = "잔돈";
    private static final String PREFIX_LAST = "개";

    private final List<Coin> changeCoins;

    public ChangeCoinDto(List<Coin> changeCoins) {
        this.changeCoins = changeCoins;
    }

    public String toString() {
        StringBuilder coinDto = new StringBuilder(PREFIX_FIRST + "\n");
        List<Coin> changeCoinsTypes = changeCoins.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Coin::getAmount).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < changeCoinsTypes.size(); i++) {
            Coin coin = changeCoinsTypes.get(i);
            coinDto.append(coin.getKoreanTag()).append(countCoin(changeCoins, coin)).append(PREFIX_LAST);
            if (i != changeCoinsTypes.size() - 1) {
                coinDto.append("\n");
            }
        }
        return coinDto.toString();
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
