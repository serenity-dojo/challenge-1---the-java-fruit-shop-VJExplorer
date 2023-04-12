package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final Catalog catalog;
    private final List<CartItem> items = new ArrayList<>();

    public Cart(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getNumberofItems() {
        return items.size();
    }

    public void addtoCart(CartItem item) {
        items.add(item);

    }

    public double getTotalQuantity() {
        return items.stream()
                .mapToDouble(item -> item.getQuantity())
                .sum();

    }


    public double getRunningTotal() {
        return items.stream()
                .mapToDouble(item -> priceOfFruit(item))
                .sum();

    }


    private double priceOfFruit(CartItem item) {
        double totalPrice = 0;
        if (item.getQuantity() >= 5) {
            totalPrice = item.getQuantity() * catalog.getPriceof(item.getFruit()) * 0.9;
        } else {
            totalPrice = item.getQuantity() * catalog.getPriceof(item.getFruit());
        }
        return totalPrice;
    }

}
