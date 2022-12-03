package vendingmachine.domain.productmanager;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProductManagerImplTest {

    @Test
    void makeProductTest() {
        //given
        ProductManager productManager = new ProductManagerImpl();
        String productInformationInput = "[콜라,1500,20];[사이다,1000,10]";

        //when
        Products result = productManager.makeProduct(productInformationInput);

        //then
        List<Product> products = result.getProducts();
        assertThat(products.size()).isEqualTo(2);
        assertThat(products.get(0).getProductName()).contains("콜라");
        assertThat(products.get(1).getProductName()).contains("사이다");

    }

}
