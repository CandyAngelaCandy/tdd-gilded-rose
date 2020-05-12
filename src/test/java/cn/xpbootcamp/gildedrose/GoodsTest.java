package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsTest {
    @Test
    void should_get_sellIn_is_5_quantity_is_15_when_past_5_days_given_a_normal_goods_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N001", "milk", GoodsType.NORMAL, 10, 20);
        milk.passDays(5);
        assertEquals(5, milk.getSellIn());
        assertEquals(15, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_negative_1_quantity_is_8_when_past_11_days_given_a_normal_goods_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N001", "milk", GoodsType.NORMAL, 10, 20);
        milk.passDays(11);
        assertEquals(-1, milk.getSellIn());
        assertEquals(8, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_negative_6_quantity_is_0_when_past_16_days_given_a_normal_goods_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N001", "milk", GoodsType.NORMAL, 10, 20);
        milk.passDays(16);
        assertEquals(-6, milk.getSellIn());
        assertEquals(0, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_5_quantity_is_25_when_past_5_days_given_a_Aged_Brie_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N002", "agedBrie", GoodsType.AGED_BRIE, 10, 20);
        milk.passDays(5);
        assertEquals(5, milk.getSellIn());
        assertEquals(25, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_negative_3_quantity_is_36_when_past_13_days_given_a_Aged_Brie_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N002", "agedBrie", GoodsType.AGED_BRIE, 10, 20);
        milk.passDays(13);
        assertEquals(-3, milk.getSellIn());
        assertEquals(36, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_negative_11_quantity_is_50_when_past_21_days_given_a_Aged_Brie_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N002", "agedBrie", GoodsType.AGED_BRIE, 10, 20);
        milk.passDays(21);
        assertEquals(-11, milk.getSellIn());
        assertEquals(50, milk.getQuantity());
    }
}
