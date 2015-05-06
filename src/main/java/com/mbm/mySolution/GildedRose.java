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

        List<AbstractItem> items = new ArrayList<AbstractItem>();
        items.add(new StandardItem("+5 Dexterity Vest", 10, 20));
        items.add(new AgedBrieItem(AGED_BRIE, 2, 0));
        items.add(new StandardItem("Elixir of the Mongoose", 5, 7));
        items.add(new SulfurasItem(SULFURAS, 0, 80));
        items.add(new BackStageItem(BACKSTAGE_PASSES, 15, 20));
        items.add(new StandardItem("Conjured Mana Cake", 3, 6));

        updateQuality(items);
    }


    public static void updateQuality(List<AbstractItem> items) {
        for (AbstractItem item : items) {
            item.updateQuality();
        }
    }




}