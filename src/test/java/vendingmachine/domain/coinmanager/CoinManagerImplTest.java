package vendingmachine.domain.coinmanager;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoinManagerImplTest {

    private static final CoinManager coinManager = new CoinManagerImpl();

    @ParameterizedTest
    @ValueSource(ints = {900, 450, 130, 100, 50, 10})
    @DisplayName("입력된 총 금액만큼의 동전들이 생성된다.")
    void makeMoneyBox(int totalAmount) {
        //given //when
        MoneyBox moneyBox = coinManager.makeMoneyBox(totalAmount);

        //then
        List<Coin> coins = moneyBox.getCoins();
        int moneyBoxAmount = 0;
        for (Coin coin : coins) {
            moneyBoxAmount += coin.getAmount();
        }
        assertThat(moneyBoxAmount).isEqualTo(totalAmount);
    }

}
