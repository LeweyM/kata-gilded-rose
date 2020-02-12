package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GildedRoseTest {
    private static final String DEFAULT = "some default item";
    private GildedRose app;

    @Test
    void shouldDecrementSellInByOne() {
        Item[] items = {new Item(DEFAULT, 3, 3)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(items[0].sellIn, equalTo(2));
    }

    @Test
    void givenQualityIsPositive_AndSellInIsPositive_thenQualityDecreasesByOne() {
        Item[] items = {new Item(DEFAULT, 3, 3)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(items[0].quality, equalTo(2));
    }
    @Test
    void givenQualityIsPositive_AndSellInIsNegative_thenQualityDecreasesByTwo() {
        Item[] items = {new Item(DEFAULT, -3, 3)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(items[0].quality, equalTo(1));
    }

}