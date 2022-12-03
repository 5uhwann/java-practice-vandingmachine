package vendingmachine.domain.productmanager;

public interface ProductManager {

    Products makeProduct(String productInformation);

    int subtractProduct(String productName);

}
