import com.mbm.mySolution.GildedRose;
import com.mbm.mySolution.Item;
import org.approvaltests.Approvals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mbm.mySolution.ItemBuilder.anItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GildedRoseTest {

	private static final int EXPIRED = -1;
	private static final int FIXED_SEED = 100;
	private static final int NUMBER_OF_RANDOM_ITEMS = 2000;
	private static final int MINIMUM = -50;
	private static final int MAXIMUN = 101;
	private List<Item> items;
	private String[] itemNames = {"+5 Dexterity Vest",
			"Aged Brie",
			"Elixir of the Mongoose",
			"Sulfuras, Hand of Ragnaros",
			"Backstage passes to a TAFKAL80ETC concert",
			"Conjured Mana Cake"};

	private Random random = new Random(FIXED_SEED);

	@Before
	public void initialise() {
		this.items = new ArrayList<Item>();
	}

	@Test
	public void shouldLowerTheSellInValue() {
		Item dexterityVest = anItem().withName(itemNames[0]).withSellIn(10).build();
		items.add(dexterityVest);
		GildedRose.updateQuality(items);
		assertThat(dexterityVest.getSellIn(), is(9));
	}

	@Test
	public void
	shouldLowerTheQualityValue() {
		Item dexterityVest = anItem().withName(itemNames[0]).withQualily(10).build();
		items.add(dexterityVest);
		GildedRose.updateQuality(items);
		assertThat(dexterityVest.getQuality(), is(9));
	}

	@Test
	public void
	shouldLowerTheQualityValueTwiceAsFastWhenSellByDateHasPassed() {
		Item dexterityVest = anItem()
				.withName(itemNames[0])
				.withQualily(10)
				.withSellIn(EXPIRED).build();
		items.add(dexterityVest);
		GildedRose.updateQuality(items);
		assertThat(dexterityVest.getQuality(), is(8));
	}

	@Test
	public void
	shouldNeverLowerTheQualityToANegativeValue() {
		Item dexterityVest = anItem().withName(itemNames[0]).withQualily(0).build();
		items.add(dexterityVest);
		GildedRose.updateQuality(items);
		assertThat(dexterityVest.getQuality(), is(0));
	}

	@Test
	public void
	shouldIncreaseAgedBrieWheverItGetsOlder() {
		Item agedBrie = anItem().withName(itemNames[1]).withQualily(10).build();
		items.add(agedBrie);
		GildedRose.updateQuality(items);
		assertThat(agedBrie.getQuality(), is(11));
	}

	@Test
	public void
	shouldNeverIncreaseTheQualityOfAItemToMoreThanFifty() {
		Item agedBrie = anItem().withName(itemNames[1]).withQualily(50).build();
		items.add(agedBrie);
		GildedRose.updateQuality(items);
		assertThat(agedBrie.getQuality(), is(50));
	}

	@Test
	public void
	shouldNeverChangeSellInAndQualityOfSulfuras() {
		Item sulfuras = anItem()
				.withName(itemNames[3])
				.withQualily(20)
				.withSellIn(10).build();
		items.add(sulfuras);
		GildedRose.updateQuality(items);
		assertThat(sulfuras.getQuality(), is(20));
		assertThat(sulfuras.getSellIn(), is(10));
	}

	@Test
	public void
	shouldIncreaseQualityByTwoOfBackstageWhenNeedsToBeSoldInTenDays() {
		Item backstage = anItem()
				.withName(itemNames[4])
				.withQualily(20)
				.withSellIn(10).build();
		items.add(backstage);
		GildedRose.updateQuality(items);
		assertThat(backstage.getQuality(), is(22));
	}

	@Test
	public void
	shouldIncreaseQualityByThreeOfBackstageWhenNeedsToBeSoldInLessThanSixDays() {
		Item backstage = anItem()
				.withName(itemNames[4])
				.withQualily(20)
				.withSellIn(5).build();
		items.add(backstage);
		GildedRose.updateQuality(items);
		assertThat(backstage.getQuality(), is(23));
	}

	@Test
	public void
	shouldSetQualityToZeroForBackstageAfterConcert() {
		Item backstage = anItem()
				.withName(itemNames[4])
				.withQualily(20)
				.withSellIn(0).build();
		items.add(backstage);
		GildedRose.updateQuality(items);
		assertThat(backstage.getQuality(), is(0));
	}


	@Test
	public void
	should_generate_update_quality_output() throws Exception {
		generateRandomItems(NUMBER_OF_RANDOM_ITEMS);

		GildedRose.updateQuality(items);

		Approvals.verify(getStringRepresentationFor(items));
	}

	private void generateRandomItems(int totalNumberOfRandomItems) {
		for (int cnt = 0; cnt < totalNumberOfRandomItems; cnt++) {
			Item randomItem = anItem()
					.withName(randomItemName())
					.withSellIn(randomSellIn())
					.withQualily(randomQuality()).build();
			items.add(randomItem);
		}
	}

	private String randomItemName() {
		return itemNames[random.nextInt(itemNames.length)];
	}

	private int randomSellIn() {
		return randomNumberBetween(MINIMUM, MAXIMUN);
	}

	private int randomQuality() {
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


}
