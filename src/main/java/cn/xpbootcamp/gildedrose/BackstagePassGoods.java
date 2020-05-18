package cn.xpbootcamp.gildedrose;

public class BackstagePassGoods {
    private int sellIn;
    private int quantity;

    public BackstagePassGoods(int sellIn, int quantity) {
        this.sellIn = sellIn;
        this.quantity = quantity;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void passDays(int pastDays) {
        boolean EXPIRE_IN_TEN_DAYS = this.sellIn - pastDays < 10;
        int DAILY_ADD_TWO_POINT = 2;

        this.sellIn--;
        if (EXPIRE_IN_TEN_DAYS) {
            this.quantity += DAILY_ADD_TWO_POINT;
        } else {
            this.quantity++;
        }

        this.quantity = Math.min(50, this.quantity);
    }
}
