package ua.goit;



import static ua.goit.Groceries.products;
import static ua.goit.Utils.calculateTotalCost;

public class Main {
    public static void main(String[] args) {

        products();

        double totalCost = calculateTotalCost("AAAAAABBCDD");
        System.out.println("Basket value = " + totalCost);
    }
}
