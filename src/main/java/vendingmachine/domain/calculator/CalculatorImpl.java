package vendingmachine.domain.calculator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import vendingmachine.domain.moneymanager.MoneyBox;
import vendingmachine.domain.productmanager.Product;
import vendingmachine.domain.productmanager.Products;

public class CalculatorImpl implements Calculator{

    @Override
    public int calculate(int inputAmount, int subtractedPrice) {
        return inputAmount - subtractedPrice;
    }

    @Override
    public Optional<Integer> payChange(MoneyBox moneyBox, Products products, String productName) {
        Optional<Product> product = products.findProductByName(productName);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.");
        }
        if (products.getMinProductPrice() > moneyBox.getInputAmount() || isSoldOut(products)) {
            return Optional.of(moneyBox.getInputAmount());
        }
        return Optional.empty();
    }

    private boolean isSoldOut(Products products) {
        List<Product> soldOutProducts = products.getProducts().stream()
                .filter(product -> product.getQuantity() == 0)
                .collect(Collectors.toList());

        return soldOutProducts.size() == products.getProducts().size();
    }
}
