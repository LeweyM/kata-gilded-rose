package com.gildedrose;

class GildedRose {
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

            item.updateSellIn();
            item.updateQuality();
        }
    }

}