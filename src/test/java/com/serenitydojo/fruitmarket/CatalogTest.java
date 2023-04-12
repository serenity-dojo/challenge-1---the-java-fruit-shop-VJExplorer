package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.Fruit;
import com.serenitydojo.FruitNotAvailable;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
// TODO: Uncomment this code and make it work
        Catalog catalog = new Catalog();
        catalog.setPriceof(Fruit.APPLE, 4.00);
        double priceofFruit = catalog.getPriceof(Fruit.APPLE);

        assertThat(priceofFruit).isEqualTo(4.00);
    }

    @Test
    public void shouldListAvailableFruitsAlphabetically() {

        Catalog catalog = new Catalog();
        catalog.setPriceof(Fruit.ORANGE, 5.50);
        catalog.setPriceof(Fruit.BANANA, 6.00);
        catalog.setPriceof(Fruit.PEAR, 4.50);

        List<Fruit> availableFruits = catalog.getAllFruitsAlphabeticalOrder();
        assertThat(availableFruits).containsExactly(Fruit.BANANA,Fruit.ORANGE,Fruit.PEAR);

    }

    @Test (expected = FruitNotAvailable.class)
    public void shouldGiveThePriceofFruit(){

        Catalog catalog = new Catalog();
        catalog.setPriceof(Fruit.ORANGE, 5.50);
        catalog.setPriceof(Fruit.BANANA, 6.00);
        catalog.setPriceof(Fruit.PEAR, 4.50);

        double priceofFruit = catalog.getPriceof(Fruit.STRWBERRY);
    }
}
