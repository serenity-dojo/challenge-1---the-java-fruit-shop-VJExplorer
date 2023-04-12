package com.serenitydojo;

import java.util.*;
import java.util.stream.Collectors;

public class Catalog {

    Map<Fruit, Double> fruitToPrice = new HashMap<>();

    public void setPriceof(Fruit fruit, double price) {

        fruitToPrice.put(fruit, price);

    }

    public double getPriceof(Fruit fruit) {
        if (!fruitToPrice.containsKey(fruit)) {
            throw new FruitNotAvailable("Sorry the " + fruit + " not available in the catalog ");
        }
        return fruitToPrice.get(fruit);

    }

    public List<Fruit> getAllFruitsAlphabeticalOrder() {
        return fruitToPrice.keySet()
                .stream()
                .sorted(Comparator.comparing(Fruit::name))
                .collect(Collectors.toList());
    }

}
