package vendingmachine.domain.productmanager;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductsTest {

    @ParameterizedTest
    @ValueSource(strings = {"콜라", "사이다"})
    @DisplayName("상품명과 일치하는 상품을 반환한다.")
    void findProductByName_case1(String productName) {
        //given
        Product productA = new Product(List.of("콜라", "1500", "20"));
        Product productB = new Product(List.of("사이다", "1000", "15"));
        Products products = new Products(List.of(productA, productB));

        //when
        Optional<Product> foundProduct = products.findProductByName(productName);

        //then
        assertThat(foundProduct.get().getProductName()).isEqualTo(productName);

    }

    @ParameterizedTest
    @ValueSource(strings = {"환타", "밀키스"})
    @DisplayName("상품명과 일치하는 상품이 없으면 빈 값을 반환한다.")
    void findProductByName_case2(String productName) {
        //given
        Product productA = new Product(List.of("콜라", "1500", "20"));
        Product productB = new Product(List.of("사이다", "1000", "15"));
        Products products = new Products(List.of(productA, productB));

        //when
        Optional<Product> foundProduct = products.findProductByName(productName);

        //then
        assertThat(foundProduct.isEmpty()).isEqualTo(true);

    }

    @Test
    @DisplayName("생성된 상품들 중 가장 낮은 가격이 저장된다.")
    void saveMinProductPrice() {
        //given
        Product productA = new Product(List.of("콜라", "1500", "20"));
        Product productB = new Product(List.of("사이다", "1000", "15"));
        Products products = new Products(List.of(productA, productB));

        //when
        int minProductPrice = products.getMinProductPrice();

        //then
        assertThat(minProductPrice).isEqualTo(productB.getPrice());

    }

}
