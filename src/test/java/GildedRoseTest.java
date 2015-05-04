import static org.junit.Assert.*;

import static org.junit.Assert.*;

import com.mbm.mySolution.GildedRose;
import com.mbm.mySolution.Item;
import org.approvaltests.Approvals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GildedRoseTest {

	private static final int FIXED_SEED = 100;
	private static final int NUMBER_OF_RANDOM_ITEMS = 2000;
	private static final int MINIMUM = -50;
	private static final int MAXIMUN = 101;

	private String[] itemNames = {"+5 Dexterity Vest",
			"Aged Brie",
			"Elixir of the Mongoose",
			"Sulfuras, Hand of Ragnaros",
			"Backstage passes to app TAFKAL80ETC concert",
			"Conjured Mana Cake"};

	private Random random = new Random(FIXED_SEED);
	private GildedRose gildedRose;

	@Before
	public void initialise() {
		gildedRose = new GildedRose();
	}

	@Test
	public void
	should_generate_update_quality_output() throws Exception {
		List<Item> items = generateRandomItems(NUMBER_OF_RANDOM_ITEMS);

		gildedRose.updateQuality(items);

		Approvals.verify(getStringRepresentationFor(items));
	}

	private List<Item> generateRandomItems(int totalNumberOfRandomItems) {
		List<Item> items = new ArrayList<Item>();
		for (int cnt = 0; cnt < totalNumberOfRandomItems; cnt++) {
			items.add(new Item(itemName(), sellIn(), quality()));
		}
		return items;
	}

	private String itemName() {
		return itemNames[random.nextInt(itemNames.length)];
	}

	private int sellIn() {
		return randomNumberBetween(MINIMUM, MAXIMUN);
	}

	private int quality() {
		return randomNumberBetween(MINIMUM, MAXIMUN);
	}

	private int randomNumberBetween(int minimum, int maximum) {
		return minimum + random.nextInt(maximum);
	}

	private String getStringRepresentationFor(List<Item> items) {
		StringBuilder builder = new StringBuilder();
		for (Item item : items) {
			builder.append(item).append("\r");
		}
		return builder.toString();
	}

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
}
