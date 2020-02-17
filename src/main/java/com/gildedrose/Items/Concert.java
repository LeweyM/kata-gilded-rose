package com.gildedrose.Items;

public class Concert extends Item {
    public Concert(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
    }

    @Override
    public void updateQuality() {
        if (sellIn < 0) {
            quality = 0;
            return;
        }

        if (sellIn < 5 && quality < 48) {
            quality += 3;
        } else if (sellIn >= 5 && sellIn < 10 && quality < 49) {
            quality += 2;
        } else if (quality < 50) {
            quality++;
        }

    }
}
