package ua.goit;




import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ua.goit.Groceries.groceriesList;
import static ua.goit.Groceries.products;

class GroceriesTest {

    @Test
    void testProducts() {
        // the test should be isolated. We should create or mock all resources here but we shouldn't call the objects directly
        products();

        List<ProductShop> testGroceriesList = new ArrayList<>();
        testGroceriesList.add(new ProductShop("Apple", 1.25, "A"));


        assertEquals(testGroceriesList.get(0).getName(), groceriesList.get(0).getName());
        assertEquals(testGroceriesList.get(0).getPrice(), groceriesList.get(0).getPrice());
        assertEquals(testGroceriesList.get(0).getProductCode(), groceriesList.get(0).getProductCode());
    }
}
