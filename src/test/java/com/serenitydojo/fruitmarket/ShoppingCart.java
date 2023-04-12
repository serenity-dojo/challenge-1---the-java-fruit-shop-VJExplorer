package com.serenitydojo.fruitmarket;

import com.serenitydojo.Cart;
import com.serenitydojo.CartItem;
import com.serenitydojo.Catalog;
import com.serenitydojo.Fruit;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCart {
    Catalog catalog = new Catalog();
    @Before
    //setup catalog
    public void setCatalog(){
        catalog.setPriceof(Fruit.APPLE,6.50);
        catalog.setPriceof(Fruit.ORANGE, 5.50);
        catalog.setPriceof(Fruit.BANANA, 6.00);
        catalog.setPriceof(Fruit.PEAR, 4.50);
    }


    @Test
    public void shouldCartbeEmpty() {
        Cart cart = new Cart(catalog);

        int numberOfItems = cart.getNumberofItems();
        assertThat(numberOfItems).isEqualTo(0);
    }

    @Test
    public void shouldCartHaveItems(){
        Cart cart = new Cart(catalog);
        cart.addtoCart(new CartItem(Fruit.APPLE,1));
        cart.addtoCart(new CartItem(Fruit.BANANA,2.5));
        cart.addtoCart(new CartItem(Fruit.PEAR,6));

        double numberofUnits = cart.getTotalQuantity();

        assertThat(numberofUnits).isEqualTo(9.5);
    }


    @Test
    public void shouldCalculateShoppingCartTotal(){

        Cart cart = new Cart(catalog);
        cart.addtoCart(new CartItem(Fruit.APPLE,1));
        cart.addtoCart(new CartItem(Fruit.BANANA,2));
        cart.addtoCart(new CartItem(Fruit.ORANGE,3));


        assertThat(cart.getRunningTotal()).isEqualTo(35.00);
    }

    @Test
    public void shouldItemsGetDiscount(){

        Cart cart = new Cart(catalog);
        cart.addtoCart(new CartItem(Fruit.APPLE,5));
        cart.addtoCart(new CartItem(Fruit.BANANA,6.5));

        assertThat(cart.getRunningTotal()).isEqualTo(64.35);
    }

}
