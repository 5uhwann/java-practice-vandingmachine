package vendingmachine.domain.productmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductManagerImpl implements ProductManager {

    @Override
    public Products makeProduct(String productInformationInput) {
        List<Product> products = new ArrayList<>();
        for (String productInformation : productInformationInput.split(";")) {
            List<String> eachProductInformation = Arrays.asList(
                    productInformation.substring(1, productInformation.length() - 1)
                            .split(","));
            products.add(new Product(eachProductInformation));
        }
        return new Products(products);
    }
}
