package ua.goit;




import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ua.goit.Groceries.groceriesList;

public class Utils {

    static Map<String, Integer> productCodesAndQuantity = new HashMap<>();

    public static double calculateTotalCost(String productCodes) {
        double totalCost;
        getCountProducts(productCodes);
        totalCost = getTotalCost();
        return totalCost;
    }

    public static double getTotalCost() {
        double total = 0;
        if (productCodesAndQuantity.containsKey("A")) {
            total += getProductsCost("A", 6, 20);
        }
        if (productCodesAndQuantity.containsKey("B")) {
            total += getProductsCost("B", 0, 0);
        }
        if (productCodesAndQuantity.containsKey("C")) {
            total += getProductsCost("C", 3, 10);
        }
        if (productCodesAndQuantity.containsKey("D")) {
            total += getProductsCost("D", 0, 0);
        }

        BigDecimal result = new BigDecimal(total);
        result = result.setScale(2, RoundingMode.HALF_UP);
        total = result.doubleValue();
        return total;
    }

    public static double getProductsCost(String code, int productQuantity, int discount) {
        double result = 0;

        if (productCodesAndQuantity.get(code) > 0) {
            if (productCodesAndQuantity.get(code) >= productQuantity) {
                double discountAmount = getPriceByProductCode(code) * discount / 100;
                result = (getPriceByProductCode(code) - discountAmount) * productCodesAndQuantity.get(code);
            } else {
                result = getPriceByProductCode(code) * productCodesAndQuantity.get(code);
            }
        }

        return result;
    }

    public static void getCountProducts(String productCodes) {

        String[] codes = productCodes.split("");
        for (String code : codes) {
            Integer codeCount = productCodesAndQuantity.get(code);
            if (codeCount == null) {
                codeCount = 0;
            }
            productCodesAndQuantity.put(code, codeCount + 1);
        }
    }

    public static double getPriceByProductCode(String productCode) {
        double price = 0;
        for (ProductShop product : groceriesList) {
            if (Objects.equals(product.getProductCode(), productCode)) {
                price = product.getPrice();
            }
        }
        if (price == 0) {
            System.out.println("Product code does not exist");
        }
        return price;
    }
}