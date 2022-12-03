package vendingmachine.domain.productmanager;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    @DisplayName("상품 이름, 상품 가격, 상품 수량 3가지 정보를 입력해야 한다.")
    void success_ValidateProductInformationSize() {
        //given
        List<String> eachProductInformation = List.of("캔커피", "4000", "10");

        // when
        Product product = new Product(eachProductInformation);

        //then
        assertThat(eachProductInformation).contains(product.getProductName());
        assertThat(eachProductInformation).contains(String.valueOf(product.getPrice()));
        assertThat(eachProductInformation).contains(String.valueOf(product.getQuantity()));

    }

    @Test
    @DisplayName("상품 이름, 상품 가격, 상품 수량 3가지 정보 외 다른 정보를 입력하면 에러가 발생한다.")
    void fail_ValidateProductInformationSize() {
        //given
        List<String> eachProductInformation = List.of("캔커피", "4000", "10", "10");

        // when //then
        assertThatThrownBy(() -> new Product(eachProductInformation)).isInstanceOf(IllegalArgumentException.class);
    }

}
