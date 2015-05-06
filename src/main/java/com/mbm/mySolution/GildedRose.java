package com.mbm.mySolution;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES, 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);
    }


    public static void updateQuality(List<Item> items) {
        for (Item item : items) {
            String itemName = item.getName();
            if (AGED_BRIE.equals(itemName)) {
                if (item.hasNotMaxQuality()) {
                    item.increaseQuality();
                }
                item.decreaseSellIn();
                if (item.hasNotMaxQuality() && item.isExpired()) {
                    item.increaseQuality();
                }

            } else if (BACKSTAGE_PASSES.equals(itemName)) {
                updateQualityForBackStage(item);
                item.decreaseSellIn();
                if (item.isExpired()) {
                    item.setQuality(0);
                }

            } else if (!SULFURAS.equals(itemName)) {
                if (item.getQuality() > 0) {
                    item.decreaseQuality();
                }
                item.decreaseSellIn();
                if (item.isExpired() && item.getQuality() > 0) {
                    item.decreaseQuality();
                }
            }

        }
    }

    private static void updateQualityForBackStage(Item item) {
        if (item.hasNotMaxQuality()) {
            item.increaseQuality();

            if (item.getSellIn() < 11) {
                if (item.hasNotMaxQuality()) {
                    item.increaseQuality();
                }
            }
            if (item.getSellIn() < 6) {
                if (item.hasNotMaxQuality()) {
                    item.increaseQuality();
                }
            }

        }
    }

}