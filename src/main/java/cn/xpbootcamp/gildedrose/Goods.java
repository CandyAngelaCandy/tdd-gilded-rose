package cn.xpbootcamp.gildedrose;

public class Goods {
    private String id;
    private String name;
    private GoodsType type;
    private int sellIn;
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Goods(String id, String name, GoodsType type, int sellIn, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sellIn = sellIn;
        this.quantity = quantity;
    }

    public void passDays(int pastDays) {
        int currentSellIn = this.sellIn - pastDays;
        int currentQuantity;
        switch (this.type) {
            case NORMAL:
                if (currentSellIn >= 0) {
                    currentQuantity = this.quantity - pastDays;
                } else {
                    currentQuantity = this.quantity - this.sellIn + 2 * currentSellIn;
                }
                currentQuantity = Math.max(currentQuantity, 0);
                break;
            case AGED_BRIE:
                if (currentSellIn >= 0) {
                    currentQuantity = this.quantity + pastDays;
                } else {
                    currentQuantity = this.quantity + this.sellIn - 2 * currentSellIn;
                }
                currentQuantity = Math.min(currentQuantity, 50);
                break;
            case SULFURAS:
                currentSellIn = this.sellIn;
                currentQuantity = this.quantity;
                break;
            case BACKSTAGE_PASS:
                if (currentSellIn < 0) {
                    currentQuantity = 0;
                } else if (currentSellIn < 5 && this.sellIn >= 10) {
                    currentQuantity = this.quantity + this.sellIn - 10 + 2 * 5 + 3 * (pastDays - 5 - (this.sellIn - 10));
                } else if (currentSellIn < 10 && this.sellIn >= 10) {
                    currentQuantity = this.quantity + this.sellIn - 10 + 2 * (10 - currentSellIn);
                } else if (this.sellIn >= 5 && this.sellIn < 10) {
                    currentQuantity = this.quantity + 2 * pastDays;
                } else {
                    currentQuantity = this.quantity + pastDays;
                }
                currentQuantity = Math.min(currentQuantity, 50);
                break;
            default:
                currentQuantity = this.quantity;
        }

        this.setSellIn(currentSellIn);
        this.setQuantity(currentQuantity);
    }
}
