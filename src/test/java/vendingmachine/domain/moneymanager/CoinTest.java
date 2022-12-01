package vendingmachine.domain.moneymanager;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoinTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 50})
    @DisplayName("남은 금액보다 작은 금액의 동전은 생성 가능하다.")
    void isAbleCoinTest_case1(int remainderAmount) {
        //given //when
        boolean result = Coin.COIN_50.isAbleCoin(remainderAmount);
        //then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {49, 10})
    @DisplayName("남은 금액보다 작은 금액의 동전은 생성 가능하다.")
    void isAbleCoinTest_case2(int remainderAmount) {
        //given //when
        boolean result = Coin.COIN_50.isAbleCoin(remainderAmount);
        //then
        assertThat(result).isEqualTo(false);
    }


}
