package vendingmachine.domain.productmanager;

import java.util.List;

public class Product {

    private static final int PRODUCT_INFORMATION_SIZE = 3;
    private static final String REGEX_NUMBER = "^[0-9]*$";

    private final String productName;
    private final int price;
    private int quantity;

    public Product(List<String> eachProductInformation) {
        validateProductInformationSize(eachProductInformation);
        validateProductInformation(eachProductInformation);
        this.productName = eachProductInformation.get(0);
        this.price = Integer.parseInt(eachProductInformation.get(1));
        this.quantity = Integer.parseInt(eachProductInformation.get(2));
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validateProductInformationSize(List<String> eachProductInformation) {
        if (eachProductInformation.size() != PRODUCT_INFORMATION_SIZE) {
            throw new IllegalArgumentException("[ERROR] 상품 정보는 이름, 가격, 수량 3가지 정보만 입력 가능합니다.");
        }
    }

    private void validateProductInformation(List<String> eachProductInformation) {
        for (int i = 1; i < eachProductInformation.size(); i++) {
            if (!eachProductInformation.get(i).matches(REGEX_NUMBER)) {
                throw new IllegalArgumentException("[ERROR] 상품 정보를 정확히 입력해주세요");
            }
        }
    }
    
}
