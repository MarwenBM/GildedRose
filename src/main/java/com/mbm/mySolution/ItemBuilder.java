package com.mbm.mySolution;

import static com.mbm.mySolution.TypeItem.AgedBrieItem;

/**
 * Created by marwen on 05/05/15.
 */
public class ItemBuilder {
    private String name;
    private int sellIn = 1;
    private int quality = 1;

    public static ItemBuilder anItem() {
        return new ItemBuilder();
    }

    public ItemBuilder withQualily(int quality) {
        this.quality = quality;
        return this;
    }

    public ItemBuilder withSellIn(int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    public ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AbstractItem build(TypeItem type) {
        AbstractItem item = null;
        switch (type) {

            case StandardIem:item = new StandardItem(name, sellIn, quality);
                break;
            case AgedBrieItem:item = new AgedBrieItem (name, sellIn, quality);
                break;
            case BackStageItem:item = new BackStageItem (name, sellIn, quality);
                break;
            case SulfurasIem:item = new SulfurasItem (name, sellIn, quality);
                break;
        }
        return  item;
    }
}