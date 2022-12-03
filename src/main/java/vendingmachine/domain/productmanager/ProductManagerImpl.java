package vendingmachine.domain.productmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManagerImpl implements ProductManager {

    private Products products;

    @Override
    public Products makeProduct(String productInformationInput) {
        List<Product> generatedProducts = new ArrayList<>();
        for (String productInformation : productInformationInput.split(";")) {
            List<String> eachProductInformation = Arrays.asList(
                    productInformation.substring(1, productInformation.length() - 1)
                            .split(","));
            generatedProducts.add(new Product(eachProductInformation));
        }
        products = new Products(generatedProducts);
        return products;
    }

    @Override
    public int subtractProduct(String productName) {
        Product subtractedProduct = products.getProducts().stream()
                .filter(product -> product.getProductName().equals(productName))
                .collect(Collectors.toList()).get(0);

        subtractedProduct.updateQuantity();
        return subtractedProduct.getPrice();
    }
}
