package vendingmachine.domain.calculator;

import java.util.Optional;
import vendingmachine.domain.moneymanager.MoneyBox;
import vendingmachine.domain.productmanager.Products;

public interface Calculator {

    int calculate(int inputAmount, int subtractedPrice);

    Optional<Integer> payChange(MoneyBox moneyBox, Products products, String productName);

}
