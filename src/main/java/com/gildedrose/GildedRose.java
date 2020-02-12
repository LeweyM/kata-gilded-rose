package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                continue;
            }

            if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                defaultSellInDecrement(item);
                if (item.quality < 50) {
                    item.quality++;

                    if (item.sellIn < 10 && item.quality < 50) {
                        item.quality++;
                    }

                    if (item.sellIn < 5 && item.quality < 50) {
                        item.quality++;
                    }
                }


                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                continue;
            }

            if (item.name.equals(AGED_BRIE)) {
                defaultSellInDecrement(item);
                if (item.quality < 50) {
                    item.quality++;
                }

                if (item.quality < 50 && item.sellIn < 0) {
                    item.quality++;
                }
                continue;
            }

            item.updateSellIn();
            item.updateQuality();
        }
    }

    private void defaultSellInDecrement(Item item) {
        item.sellIn--;
    }

}