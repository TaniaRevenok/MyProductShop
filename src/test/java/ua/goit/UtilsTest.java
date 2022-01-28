package ua.goit;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ua.goit.Groceries.products;
import static ua.goit.Utils.*;

class UtilsTest {

    @BeforeEach
    void startProductsMethod() {
        // the test should be isolated. We should create or mock all resources here, but we shouldn't call the objects directly
        products();
    }

    @AfterEach
    //where is the productCodesAndQuantity object? We shouldn't use any resources directly
    void clearProductCodesAndQuantity() {
        productCodesAndQuantity.clear();
    }

    @Test
    void testGetPriceByProductCode() {
        double expected = 1.25;
        double actual = Utils.getPriceByProductCode("A");
        assertEquals(expected, actual);
    }

    @Test
    void testGetPriceByProductCodeNotExist() {
        double expected = 0;
        double actual = Utils.getPriceByProductCode("F");
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountProducts() {
        Map<String, Integer> testProductCodesAndQuantity = new HashMap<>();
        testProductCodesAndQuantity.put("A", 1);
        testProductCodesAndQuantity.put("B", 3);

        getCountProducts("ABBB");

        assertEquals(testProductCodesAndQuantity.get("A"), productCodesAndQuantity.get("A"));
        assertEquals(testProductCodesAndQuantity.get("B"), productCodesAndQuantity.get("B"));
    }

    @Test
    void testGetProductsCost() {
        getCountProducts("AAAAAA");

        double expected = 6;
        double actual = getProductsCost("A", 5, 20);
        assertEquals(expected, actual);
    }

    @Test
    void testGetProductsCostWithoutDiscount() {
        getCountProducts("BB");

        double expected = 3;
        double actual = getProductsCost("B", 3, 0);
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalCost() {
        getCountProducts("AAAAAABBCCCDD");
        //what happens here? Each method return double value but we don't use it
        getProductsCost("A", 6, 20);
        getProductsCost("B", 0, 0);
        getProductsCost("C", 3, 10);
        getProductsCost("D", 0, 0);

        double expected = 22.64;
        double actual = getTotalCost();
        assertEquals(expected, actual);
    }

    @Test
    void testCalculateTotalCost() {

        double expected = 22.64;
        double actual = calculateTotalCost("AAAAAABBCCCDD");
        assertEquals(expected, actual);
    }

  
    }
}
