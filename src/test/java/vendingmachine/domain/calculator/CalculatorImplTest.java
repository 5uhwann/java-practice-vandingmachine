package vendingmachine.domain.calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.moneymanager.InputAmount;
import vendingmachine.domain.moneymanager.MoneyBox;
import vendingmachine.domain.moneymanager.MoneyManager;
import vendingmachine.domain.moneymanager.MoneyManagerImpl;
import vendingmachine.domain.productmanager.Product;
import vendingmachine.domain.productmanager.Products;

class CalculatorImplTest {

    private static final CalculatorImpl calculator = new CalculatorImpl();

    @Test
    void calculateTest() {
        //given
        int inputAmount = 4000;
        int subtractedPrice = 1500;

        //when
        int calculatedAmount = calculator.calculate(inputAmount, subtractedPrice);

        //then
        assertThat(calculatedAmount).isEqualTo(inputAmount - subtractedPrice);
    }

    @Test
    @DisplayName("잔돈 반환 조건에 해당하지 않을경우 잔돈금액은 빈 값이다.")
    void payChangeTest_case1() {
        //given
        MoneyManager moneyManager = new MoneyManagerImpl();
        MoneyBox moneyBox = moneyManager.makeMoneyBox(2000);
        moneyManager.saveInputAmount(new InputAmount(2000));

        Product productA = new Product(List.of("콜라", "1500", "20"));
        Product productB = new Product(List.of("사이다", "1000", "15"));
        Products products = new Products(List.of(productA, productB));

        String productName = productA.getProductName();

        //when
        Optional<Integer> change = calculator.payChange(moneyBox, products, productName);

        //then
        assertThat(change.isEmpty()).isEqualTo(true);

    }

    @Test
    @DisplayName("투입금액이 상품의 최소금액보다 적을 경우 잔돈을 반환한다.")
    void payChangeTest_case2() {
        //given
        MoneyManager moneyManager = new MoneyManagerImpl();
        MoneyBox moneyBox = moneyManager.makeMoneyBox(500);
        moneyManager.saveInputAmount(new InputAmount(500));

        Product productA = new Product(List.of("콜라", "1500", "20"));
        Product productB = new Product(List.of("사이다", "1000", "15"));
        Products products = new Products(List.of(productA, productB));

        String productName = productA.getProductName();

        //when
        Optional<Integer> change = calculator.payChange(moneyBox, products, productName);

        //then
        assertThat(change.get()).isEqualTo(moneyBox.getInputAmount());

    }

    @Test
    @DisplayName("모든 상품이 소진된 경우 잔돈이 반환된다.")
    void payChangeTest_case3() {
        //given
        MoneyManager moneyManager = new MoneyManagerImpl();
        MoneyBox moneyBox = moneyManager.makeMoneyBox(1500);
        moneyManager.saveInputAmount(new InputAmount(1500));

        Product productA = new Product(List.of("콜라", "1500", "0"));
        Product productB = new Product(List.of("사이다", "1000", "0"));
        Products products = new Products(List.of(productA, productB));

        String productName = productA.getProductName();

        //when
        Optional<Integer> change = calculator.payChange(moneyBox, products, productName);

        //then
        assertThat(change.get()).isEqualTo(moneyBox.getInputAmount());

    }
}
