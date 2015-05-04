package com.mbm.original;

import java.util.ArrayList;
import java.util.List;


public class OriginalGildedRose {

	private static List<OriginalItem> originalItems = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        originalItems = new ArrayList<OriginalItem>();
        originalItems.add(new OriginalItem("+5 Dexterity Vest", 10, 20));
        originalItems.add(new OriginalItem("Aged Brie", 2, 0));
        originalItems.add(new OriginalItem("Elixir of the Mongoose", 5, 7));
        originalItems.add(new OriginalItem("Sulfuras, Hand of Ragnaros", 0, 80));
        originalItems.add(new OriginalItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        originalItems.add(new OriginalItem("Conjured Mana Cake", 3, 6));

        updateQuality();
}


	
    public static void updateQuality()
    {
        for (int i = 0; i < originalItems.size(); i++)
        {
            if ((!"Aged Brie".equals(originalItems.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(originalItems.get(i).getName()))
            {
                if (originalItems.get(i).getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(originalItems.get(i).getName()))
                    {
                        originalItems.get(i).setQuality(originalItems.get(i).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (originalItems.get(i).getQuality() < 50)
                {
                    originalItems.get(i).setQuality(originalItems.get(i).getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(originalItems.get(i).getName()))
                    {
                        if (originalItems.get(i).getSellIn() < 11)
                        {
                            if (originalItems.get(i).getQuality() < 50)
                            {
                                originalItems.get(i).setQuality(originalItems.get(i).getQuality() + 1);
                            }
                        }

                        if (originalItems.get(i).getSellIn() < 6)
                        {
                            if (originalItems.get(i).getQuality() < 50)
                            {
                                originalItems.get(i).setQuality(originalItems.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(originalItems.get(i).getName()))
            {
                originalItems.get(i).setSellIn(originalItems.get(i).getSellIn() - 1);
            }

            if (originalItems.get(i).getSellIn() < 0)
            {
                if (!"Aged Brie".equals(originalItems.get(i).getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(originalItems.get(i).getName()))
                    {
                        if (originalItems.get(i).getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(originalItems.get(i).getName()))
                            {
                                originalItems.get(i).setQuality(originalItems.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        originalItems.get(i).setQuality(originalItems.get(i).getQuality() - originalItems.get(i).getQuality());
                    }
                }
                else
                {
                    if (originalItems.get(i).getQuality() < 50)
                    {
                        originalItems.get(i).setQuality(originalItems.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }

}