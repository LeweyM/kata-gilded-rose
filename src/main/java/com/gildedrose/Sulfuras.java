package com.gildedrose;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
        return;
    }

    @Override
    public void updateQuality() {
        return;
    }
}
