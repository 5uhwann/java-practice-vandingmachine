package vendingmachine.domain.moneymanager;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.moneymanager.coin.Coin;

class MoneyManagerImplTest {

    private static final MoneyManager moneyManager = new MoneyManagerImpl();

    @ParameterizedTest
    @ValueSource(ints = {900, 450, 130, 100, 50, 10})
    @DisplayName("입력된 총 금액만큼의 동전들이 생성된다.")
    void makeMoneyBox(int totalAmount) {
        //given //when
        MoneyBox moneyBox = moneyManager.makeMoneyBox(totalAmount);

        //then
        List<Coin> coins = moneyBox.getCoins();
        int moneyBoxAmount = 0;
        for (Coin coin : coins) {
            moneyBoxAmount += coin.getAmount();
        }
        assertThat(moneyBoxAmount).isEqualTo(totalAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {2000, 3000})
    @DisplayName("투입된 금액을 저장소에 저장한다.")
    void saveInputAmountTest(int receivedAmount) {
        //given
        MoneyBox moneyBox = moneyManager.makeMoneyBox(2000);
        InputAmount inputAmount = new InputAmount(receivedAmount);

        //when
        moneyManager.saveInputAmount(inputAmount);

        //then
        assertThat(moneyBox.getInputAmount()).isEqualTo(receivedAmount);
    }

    @Test
    @DisplayName("투입 금액을 최신화한다.")
    void updateInputAmountTest() {
        //given
        MoneyBox moneyBox = moneyManager.makeMoneyBox(2000);
        moneyManager.saveInputAmount(new InputAmount(3000));
        int updateInputAmount = 1500;

        //when
        moneyManager.updateInputAmount(updateInputAmount);

        //then
        assertThat(moneyBox.getInputAmount()).isEqualTo(updateInputAmount);

    }

}
