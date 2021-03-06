package com.gildedrose.Items;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateSellIn() {
        sellIn--;
    }

    public void updateQuality() {
        if (quality > 0) {
            quality--;
        }
        if (sellIn < 0 && quality > 0) {
            quality--;
        }
    }

}
