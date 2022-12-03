package vendingmachine.domain.productmanager;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductManagerImplTest {

    private static final ProductManager productManager = new ProductManagerImpl();

    @Test
    void makeProductTest() {
        //given
        String productInformationInput = "[콜라,1500,20];[사이다,1000,10]";

        //when
        Products result = productManager.makeProduct(productInformationInput);

        //then
        List<Product> products = result.getProducts();
        assertThat(products.size()).isEqualTo(2);
        assertThat(products.get(0).getProductName()).contains("콜라");
        assertThat(products.get(1).getProductName()).contains("사이다");

    }

    @Test
    @DisplayName("상품을 구매(차감)하면 해당 상품의 수량이 1줄고, 해당 상품의 가격이 반환된다.")
    void subtractProductTest() {
        //given
        Products products = productManager.makeProduct("[콜라,1500,20];[사이다,1000,10]");
        int beforeSubtractedProductQuantity = products.getProducts().get(0).getQuantity();
        String subtractProductName = "콜라";

        //when
        int subtractedProductPrice = productManager.subtractProduct(subtractProductName);

        //then
        int afterSubtractedProductQuantity = products.getProducts().get(0).getQuantity();
        assertThat(afterSubtractedProductQuantity).isEqualTo(beforeSubtractedProductQuantity - 1);
        assertThat(subtractedProductPrice).isEqualTo(products.getProducts().get(0).getPrice());

    }

}
