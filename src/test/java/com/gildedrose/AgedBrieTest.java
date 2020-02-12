package com.gildedrose;

import com.gildedrose.Items.AgedBrie;
import com.gildedrose.Items.Item;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class AgedBrieTest {
    private static final String AGED_BRIE = "Aged Brie";
    private GildedRose app;

    @Test
    void given_SellInIsGreaterThanZero_then_shouldDecrementSellInByOne() {
        Item[] items = {new AgedBrie(AGED_BRIE, 3, 3)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(app.items[0].sellIn, equalTo(2));
    }

    @Test
    void given_SellInIsLessThanZero_and_QualityIsLessThanFifty_then_QualityShouldIncreaseByTwo() {
        Item[] items = {new AgedBrie(AGED_BRIE, -1, 40)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(app.items[0].quality, equalTo(42));
    }
}