package com.mbm.mySolution;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        List<AbstractItem> items = createItems();

        updateQuality(items);
    }

    private static List<AbstractItem> createItems() {
        List<AbstractItem> items = new ArrayList<AbstractItem>();

        items.add(new StandardItem("+5 Dexterity Vest", 10, 20));
        items.add(new AgedBrieItem("Aged Brie", 2, 0));
        items.add(new StandardItem("Elixir of the Mongoose", 5, 7));
        items.add(new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new BackStageItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new StandardItem("Conjured Mana Cake", 3, 6));
        return items;
    }


    public static void updateQuality(List<AbstractItem> items) {
        for (AbstractItem item : items) {
            item.updateQuality();
        }
    }


}