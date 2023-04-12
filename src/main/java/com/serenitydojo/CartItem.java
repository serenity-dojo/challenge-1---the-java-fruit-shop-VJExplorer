package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;


public class CartItem {

    private final Fruit fruit;
    private final double quantity;

    List<CartItem> cartItems = new ArrayList<>();

    public CartItem(Fruit fruit , double quantity){
        this.fruit =fruit;
        this.quantity = quantity;
    }

    public void addCartItem(CartItem item){
        cartItems.add(item);
    }


    public double getQuantity(){
        return quantity;
    }

    public  Fruit getFruit(){
        return fruit;
    }



}
