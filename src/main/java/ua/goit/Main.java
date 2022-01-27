package ua.goit;



import static ua.goit.Groceries.products;
import static ua.goit.Utils.calculateTotalCost;

public class Main {

    // Generally spoken try using less static and void methods. In such application it can maybe work, but soon it will produce
    // more issues as solve
    public static void main(String[] args) {

        products();

        double totalCost = calculateTotalCost("AAAAAABBCDD");
        System.out.println("Basket value = " + totalCost);
    }
}
