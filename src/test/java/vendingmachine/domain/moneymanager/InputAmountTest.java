package vendingmachine.domain.moneymanager;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 10_100, 515})
    @DisplayName("10원보다 작거나 10000원보다 크거나 10원단위의 금액이 아닌 돈을 투입하면 에러가 발생한다.")
    void validateInputAmountTest(int inputAmount) {
        //given //when //then
        assertThatThrownBy(() -> new InputAmount(inputAmount)).isInstanceOf(IllegalArgumentException.class);

    }

}
