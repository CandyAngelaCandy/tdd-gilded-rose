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
       if (currentSellIn >= 0) {
           currentQuantity = this.quantity - currentSellIn;
       } else {
           currentQuantity = this.quantity - this.sellIn + 2 * currentSellIn;
       }
       this.setSellIn(currentSellIn);
       this.setQuantity(currentQuantity);
    }
}
