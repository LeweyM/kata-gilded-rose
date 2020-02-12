package com.gildedrose;

import com.gildedrose.Items.Concert;
import com.gildedrose.Items.Item;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class ConcertTest {
    private static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private GildedRose app;

    @Test
    void givenQualityIsLessThanFifty_thenQualityIncreasesByOne() {
        Item[] items = {new Concert(CONCERT, 12, 40)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(app.items[0].quality, equalTo(41));
    }

    @Test
    void givenQualityIsLessThanFifty_andSellInBetweenElevenAndSix_thenQualityIncreasesByTwo() {
        Item[] items = {new Concert(CONCERT, 8, 40)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(app.items[0].quality, equalTo(42));
    }

    @Test
    void givenQualityIsLessThanFifty_andSellInLessThanSix_thenQualityIncreasesByThree() {
        Item[] items = {new Concert(CONCERT, 4, 40)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(app.items[0].quality, equalTo(43));
    }

    @Test
    void givenQualityIsGreaterThanFifty_andSellIsNegative_thenQualityIsZero() {
        Item[] items = {new Concert(CONCERT, -8, 60)};
        app = new GildedRose(items);

        app.updateItems();

        assertThat(app.items[0].quality, equalTo(0));
    }

}