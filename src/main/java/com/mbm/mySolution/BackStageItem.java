package com.mbm.mySolution;

/**
 * Created by marwen on 06/05/15.
 */
public class BackStageItem extends AbstractItem {
    public BackStageItem(String agedBrie, int sellin, int quality) {
        super(agedBrie, sellin, quality);
    }
    @Override
    void updateQuality() {
        if (this.hasNotMaxQuality()) {
            this.increaseQuality();

            if (this.getSellIn() < 11) {
                if (this.hasNotMaxQuality()) {
                    this.increaseQuality();
                }
            }
            if (this.getSellIn() < 6) {
                if (this.hasNotMaxQuality()) {
                    this.increaseQuality();
                }
            }

        }
        this.decreaseSellIn();
        if (this.isExpired()) {
            this.setQuality(0);
        }
    }

}
