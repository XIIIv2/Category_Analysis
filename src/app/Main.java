package app;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));

        System.out.println("Результат: " + result);

        Map.Entry<String, Double> maxPrice = result.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();

        System.out.printf("Max: %s=%s", maxPrice.getKey(), maxPrice.getValue());
    }
}
