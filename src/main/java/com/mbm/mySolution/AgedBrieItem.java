package com.mbm.mySolution;

/**
 * Created by marwen on 06/05/15.
 */
public class AgedBrieItem extends AbstractItem {

    public AgedBrieItem(String agedBrie, int sellin, int quality) {
        super(agedBrie, sellin, quality);
    }

    @Override
    void updateQuality() {
        if (this.hasNotMaxQuality()) {
            this.increaseQuality();
        }
        this.decreaseSellIn();
        if (this.hasNotMaxQuality() && this.isExpired()) {
            this.increaseQuality();
        }

    }
}
