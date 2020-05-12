package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {
    @Test
    public void should_get_sellIn_is_5_quantity_is_15_when_past_5_days_given_a_normal_goods_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N001", "milk", GoodsType.NORMAL, 10, 20);
        milk.passDays(5);
        assertEquals(milk.getSellIn(), 5);
        assertEquals(milk.getQuantity(), 15);
    }

    @Test
    public void should_get_sellIn_is_negative_1_quantity_is_8_when_past_11_days_given_a_normal_goods_with_sellIn_is_10_quantity_is_20() {
        Goods milk = new Goods("N001", "milk", GoodsType.NORMAL, 10, 20);
        milk.passDays(11);
        assertEquals(milk.getSellIn(), -1);
        assertEquals(milk.getQuantity(), 8);
    }
}
