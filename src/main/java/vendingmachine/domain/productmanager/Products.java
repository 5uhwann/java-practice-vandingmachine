package vendingmachine.domain.productmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Products {

    private final List<Product> products;
    private final int minProductPrice;

    public Products(List<Product> products) {
        this.products = new ArrayList<>(products);
        this.minProductPrice = saveMinProductPrice(products);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public int getMinProductPrice() {
        return minProductPrice;
    }

    public Optional<Product> findProductByName(String productName) {
        return products.stream()
                .filter(product -> product.getProductName().equals(productName))
                .findAny();
    }

    private int saveMinProductPrice(List<Product> products) {
        List<Integer> productPrices = products.stream()
                .map(Product::getPrice)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return productPrices.get(productPrices.size() - 1);
    }
}
