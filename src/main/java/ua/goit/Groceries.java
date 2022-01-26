package ua.goit;





import java.util.ArrayList;
import java.util.List;

public class Groceries {
    static List<ProductShop> groceriesList = new ArrayList<>();

    public static void products() {
        groceriesList.add(new ProductShop("Apple", 1.25, "A"));
        groceriesList.add(new ProductShop("Banana", 1.5, "B"));
        groceriesList.add(new ProductShop("Peach", 3.2, "C"));
        groceriesList.add(new ProductShop("Apricot", 2.5, "D"));
    }
}