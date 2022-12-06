package vendingmachine.domain.moneymanager;

import static org.assertj.core.api.Assertions.*;
import static vendingmachine.domain.moneymanager.Coin.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyBoxTest {

    @Test
    @DisplayName("반환해야할 잔돈이 총 보유금액보다 많을 경우 보유한 모든 동전을 반환한다.")
    void withdrawCoinTest_case1() {
        //given
        MoneyBox moneyBox = new MoneyBox(List.of(COIN_500, COIN_100, COIN_100, COIN_50, COIN_10, COIN_10));
        int change = 1000;

        //when
        List<Coin> changeCoins = moneyBox.withdrawCoin(change);

        //then
        assertThat(changeCoins.size()).isEqualTo(moneyBox.getCoins().size());
        for (Coin coin : moneyBox.getCoins()) {
            assertThat(changeCoins).contains(coin);
        }
    }

    @Test
    @DisplayName("반환해야할 금액을 최소한의 동전 개수로 반환환다.")
    void withdrawCoinTest_case2() {
        //given
        MoneyBox moneyBox = new MoneyBox(
                List.of(COIN_500, COIN_100, COIN_100, COIN_100, COIN_50, COIN_50, COIN_50, COIN_50, COIN_10, COIN_10));
        int change = 500;

        //when
        List<Coin> changeCoins = moneyBox.withdrawCoin(change);

        //then
        assertThat(changeCoins.size()).isEqualTo(1);
        assertThat(changeCoins).contains(COIN_500);
    }


    @Test
    @DisplayName("반환해야할 동전이 부족할 경우 에러가 발생한다.")
    void withdrawCoinTest_case3() {
        //given
        MoneyBox moneyBox = new MoneyBox(
                List.of(COIN_500, COIN_100, COIN_100, COIN_100, COIN_50, COIN_50, COIN_50, COIN_50, COIN_10, COIN_10));
        int change = 680;

        //when //then
        assertThatThrownBy(() -> moneyBox.withdrawCoin(change)).isInstanceOf(IllegalArgumentException.class);

    }
}
