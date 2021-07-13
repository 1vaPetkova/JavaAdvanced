package T03SetsAndMapsAdvanced.lab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, Map<String, Double>> products = new TreeMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("Revision")) {
            String shop = input.split(",\\s+")[0];
            String product = input.split(",\\s+")[1];
            double price = Double.parseDouble(input.split(",\\s+")[2]);
            products.putIfAbsent(shop, new LinkedHashMap<>());
            products.get(shop).putIfAbsent(product, price);
        }
        products.forEach((k, v) -> {
                    System.out.println(k + "->");
                    v.forEach((product, price) ->
                            System.out.println("Product: " + product + ", Price: " + String.format("%.1f", price)));
                }
        );
    }
}
