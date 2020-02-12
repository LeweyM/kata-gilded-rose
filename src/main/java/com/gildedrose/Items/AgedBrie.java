package com.gildedrose.Items;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality++;
        }

        if (quality < 50 && sellIn < 0) {
            quality++;
        }
    }
}
