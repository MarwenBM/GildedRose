package com.mbm.mySolution;

public class StandardItem extends AbstractItem {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        if (this.getQuality() > 0) {
            this.decreaseQuality();
        }
        this.decreaseSellIn();
        if (this.isExpired() && this.getQuality() > 0) {
            this.decreaseQuality();
        }    }

}
