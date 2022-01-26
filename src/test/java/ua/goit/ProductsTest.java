package ua.goit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    ProductShop products;

    @BeforeEach
    void createProduct() {
        products = new ProductShop("Apple", 1.25, "A");
    }


    @Test
    void testGetName() {
        assertEquals("Apple", products.getName());
    }

    @Test
    void testSetName() {
        products.setName("Banana");
        assertEquals("Banana", products.getName());
    }

    @Test
    void testGetPrice() {
        assertEquals(1.25, products.getPrice());
    }

    @Test
    void setPrice() {
        products.setPrice(1.5);
        assertEquals(1.5, products.getPrice());
    }

    @Test
    void getProductCode() {
        assertEquals("A", products.getProductCode());
    }

    @Test
    void setProductCode() {
        products.setProductCode("B");
        assertEquals("B", products.getProductCode());
    }
}