package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GildedRoseTest {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String DEFAULT = "some default item";
    private static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private GildedRose app;

    //default
    //then -> should decrement sellIn by 1
    //given quality > 0
        //quality -1
        //given sellin < 0
            // quality -2

    @Test
    void shouldDecrementSellInByOne() {
        Item[] items = {new Item(DEFAULT, 3, 3)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(items[0].sellIn, equalTo(2));
    }

    @Test
    void givenQualityIsPositive_AndSellInIsPositive_thenQualityDecreasesByOne() {
        Item[] items = {new Item(DEFAULT, 3, 3)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(items[0].quality, equalTo(2));
    }
    @Test
    void givenQualityIsPositive_AndSellInIsNegative_thenQualityDecreasesByTwo() {
        Item[] items = {new Item(DEFAULT, -3, 3)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(items[0].quality, equalTo(1));
    }

    //aged brie

    //given -> sellIn is greater than 0
        // it -> should decrement sellIn by 1
    //given -> sellIn is less than 0
        //and -> quality is less than 50
            //it -> should increase quality by two

    @Test
    void given_SellInIsGreaterThanZero_then_shouldDecrementSellInByOne() {
        Item[] items = {new Item(AGED_BRIE, 3, 3)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn, equalTo(2));
    }

    @Test
    void given_SellInIsLessThanZero_and_QualityIsLessThanFifty_then_QualityShouldIncreaseByTwo() {
        Item[] items = {new Item(AGED_BRIE, -1, 40)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, equalTo(42));
    }

    //concert

    //given quality is less than 50
        //and sellIn greater than 11
            //then -> quality plus 1
        //and sellin less than 11 but greater than 6
            //then -> quality plus 2
        //and sellin less than 6
            //then -> quality plus 3
    //given quality greater than 50
        //and sellIn negative
            //then -> quality set to zero

    @Test
    void givenQualityIsLessThanFifty_thenQualityIncreasesByOne() {
        Item[] items = {new Item(CONCERT, 12, 40)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, equalTo(41));
    }

    @Test
    void givenQualityIsLessThanFifty_andSellInBetweenElevenAndSix_thenQualityIncreasesByTwo() {
        Item[] items = {new Item(CONCERT, 8, 40)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, equalTo(42));
    }

    @Test
    void givenQualityIsLessThanFifty_andSellInLessThanSix_thenQualityIncreasesByThree() {
        Item[] items = {new Item(CONCERT, 8, 40)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, equalTo(43));
    }

    @Test
    void givenQualityIsGreaterThanFifty_andSellIsNegative_thenQualityIsZero() {
        Item[] items = {new Item(CONCERT, -8, 60)};
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, equalTo(0));
    }


    //Sulfuras
    //nothing...
}