package com.gildedrose;

import com.gildedrose.Items.AgedBrie;
import com.gildedrose.Items.Concert;
import com.gildedrose.Items.Item;
import com.gildedrose.Items.Sulfuras;

public class TexttestFixture {

    private final GildedRose app;
    private final Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new AgedBrie("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
            new Concert("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Concert("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Concert("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

    public TexttestFixture() {
        app = new GildedRose(items);
    }

    String serializeDays(int days) {
        StringBuilder sb = new StringBuilder();
        sb.append("OMGHAI!");

        for (int i = 0; i < days; i++) {
            sb.append(serializeDay(items, i));
            app.updateItems();
        }

        return sb.toString();
    }

    private static String serializeDay(Item[] items, int day) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------- day " + day + " --------");
        sb.append("\nname, sellIn, quality");
        for (Item item : items) {
            sb.append("\n" + item);
        }
        sb.append("\n");
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.print(serializeDay(items, i));
            app.updateItems();
        }
    }
}
