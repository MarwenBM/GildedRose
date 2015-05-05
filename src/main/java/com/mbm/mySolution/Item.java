package com.mbm.mySolution;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    boolean isExpired() {
        return getSellIn() < 0;
    }

    void decreaseQuality() {
        setQuality(getQuality() - 1);
    }

    void increaseQuality() {
        setQuality(getQuality() + 1);
    }

    void decreaseSellIn() {
        setSellIn(getSellIn() - 1);
    }

    boolean hasNotMaxQuality() {
        return getQuality() < 50;
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                '}';
    }
}
