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

    @Test
    void should_get_sellIn_is_5_quantity_is_0_when_past_5_days_given_a_normal_goods_with_sellIn_is_10_quantity_is_2() {
        Goods milk = new Goods("N001", "milk", GoodsType.NORMAL, 10, 2);
        milk.passDays(5);
        assertEquals(5, milk.getSellIn());
        assertEquals(0, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_5_quantity_is_50_when_past_5_days_given_a_Aged_Brie_with_sellIn_is_10_quantity_is_48() {
        Goods milk = new Goods("N002", "agedBrie", GoodsType.AGED_BRIE, 10, 48);
        milk.passDays(5);
        assertEquals(5, milk.getSellIn());
        assertEquals(50, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_5_quantity_is_20_when_past_50_days_given_a_Sulfuras_with_sellIn_is_5_quantity_is_20() {
        Goods milk = new Goods("N003", "Sulfuras", GoodsType.SULFURAS, 5, 20);
        milk.passDays(50);
        assertEquals(5, milk.getSellIn());
        assertEquals(20, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_13_quantity_is_32_when_past_2_days_given_a_Backstage_Pass_with_sellIn_is_15_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 15, 30);
        milk.passDays(2);
        assertEquals(13, milk.getSellIn());
        assertEquals(32, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_7_quantity_is_41_when_past_8_days_given_a_Backstage_Pass_with_sellIn_is_15_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 15, 30);
        milk.passDays(8);
        assertEquals(7, milk.getSellIn());
        assertEquals(41, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_4_quantity_is_48_when_past_11_days_given_a_Backstage_Pass_with_sellIn_is_15_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 15, 30);
        milk.passDays(11);
        assertEquals(4, milk.getSellIn());
        assertEquals(48, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_0_quantity_is_50_when_past_15_days_given_a_Backstage_Pass_with_sellIn_is_15_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 15, 30);
        milk.passDays(15);
        assertEquals(0, milk.getSellIn());
        assertEquals(50, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_negative_1_quantity_is_0_when_past_16_days_given_a_Backstage_Pass_with_sellIn_is_15_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 15, 30);
        milk.passDays(16);
        assertEquals(-1, milk.getSellIn());
        assertEquals(0, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_6_quantity_is_34_when_past_2_days_given_a_Backstage_Pass_with_sellIn_is_8_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 8, 30);
        milk.passDays(2);
        assertEquals(6, milk.getSellIn());
        assertEquals(34, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_4_quantity_is_39_when_past_4_days_given_a_Backstage_Pass_with_sellIn_is_8_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 8, 30);
        milk.passDays(4);
        assertEquals(4, milk.getSellIn());
        assertEquals(39, milk.getQuantity());
    }

    @Test
    void should_get_sellIn_is_1_quantity_is_36_when_past_2_days_given_a_Backstage_Pass_with_sellIn_is_3_quantity_is_30() {
        Goods milk = new Goods("N004", "Backstage_Pass", GoodsType.BACKSTAGE_PASS, 3, 30);
        milk.passDays(2);
        assertEquals(1, milk.getSellIn());
        assertEquals(36, milk.getQuantity());
    }
}
