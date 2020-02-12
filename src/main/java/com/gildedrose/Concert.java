package com.gildedrose;

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
        if (quality < 50) {
            quality++;

            if (sellIn < 10 && quality < 50) {
                quality++;
            }

            if (sellIn < 5 && quality < 50) {
                quality++;
            }
        }


        if (sellIn < 0) {
            quality = 0;
        }
    }
}
