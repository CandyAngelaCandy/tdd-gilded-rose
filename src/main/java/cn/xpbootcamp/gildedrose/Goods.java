package cn.xpbootcamp.gildedrose;

public class Goods {
    public static final int GOODS_MAX_VALUE = 50;
    public static final int GOODS_MIN_VALUE = 0;
    public static final int FIVE_DAYS_TO_SELL_IN = 5;
    public static final int TEN_DAYS_TO_SELL_IN = 10;
    public static final int TWO_POINT_FOR_SPEED = 2;
    public static final int THREE_POINT_FOR_SPEED = 3;
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
                    currentQuantity = this.quantity - this.sellIn + TWO_POINT_FOR_SPEED * currentSellIn;
                }
                currentQuantity = Math.max(currentQuantity, GOODS_MIN_VALUE);
                break;
            case AGED_BRIE:
                if (currentSellIn >= 0) {
                    currentQuantity = this.quantity + pastDays;
                } else {
                    currentQuantity = this.quantity + this.sellIn - TWO_POINT_FOR_SPEED * currentSellIn;
                }
                currentQuantity = Math.min(currentQuantity, GOODS_MAX_VALUE);
                break;
            case SULFURAS:
                currentSellIn = this.sellIn;
                currentQuantity = this.quantity;
                break;
            case BACKSTAGE_PASS:
                if (currentSellIn < 0) {
                    currentQuantity = GOODS_MIN_VALUE;
                } else if (currentSellIn < FIVE_DAYS_TO_SELL_IN && this.sellIn >= TEN_DAYS_TO_SELL_IN) {
                    int addedValueBeforeTenDays = this.sellIn - TEN_DAYS_TO_SELL_IN;
                    int addedValueBetweenFiveAndTenDays = TWO_POINT_FOR_SPEED * FIVE_DAYS_TO_SELL_IN;
                    int addedValueInFiveDays = THREE_POINT_FOR_SPEED * (pastDays - FIVE_DAYS_TO_SELL_IN - (this.sellIn - TEN_DAYS_TO_SELL_IN));
                    currentQuantity = this.quantity + addedValueBeforeTenDays + addedValueBetweenFiveAndTenDays + addedValueInFiveDays;
                } else if (currentSellIn < TEN_DAYS_TO_SELL_IN && this.sellIn >= TEN_DAYS_TO_SELL_IN) {
                    int addedValueBeforeTenDays = this.sellIn - TEN_DAYS_TO_SELL_IN;
                    int addedBetweenInTenDays = TWO_POINT_FOR_SPEED * (TEN_DAYS_TO_SELL_IN - currentSellIn);
                    currentQuantity = this.quantity + addedValueBeforeTenDays + addedBetweenInTenDays;
                } else if (this.sellIn >= FIVE_DAYS_TO_SELL_IN && this.sellIn < TEN_DAYS_TO_SELL_IN && currentSellIn >= FIVE_DAYS_TO_SELL_IN) {
                    currentQuantity = this.quantity + TWO_POINT_FOR_SPEED * pastDays;
                } else if (this.sellIn >= FIVE_DAYS_TO_SELL_IN && this.sellIn < TEN_DAYS_TO_SELL_IN) {
                    int addedValueBeforeFiveDays = TWO_POINT_FOR_SPEED * (this.sellIn - FIVE_DAYS_TO_SELL_IN);
                    int addedValueInFiveDays = THREE_POINT_FOR_SPEED * (pastDays - (this.sellIn - FIVE_DAYS_TO_SELL_IN));
                    currentQuantity = this.quantity + addedValueBeforeFiveDays + addedValueInFiveDays;
                } else if (this.sellIn < FIVE_DAYS_TO_SELL_IN) {
                    currentQuantity = this.quantity + THREE_POINT_FOR_SPEED * pastDays;
                } else {
                    currentQuantity = this.quantity + pastDays;
                }
                currentQuantity = Math.min(currentQuantity, GOODS_MAX_VALUE);
                break;
            default:
                currentQuantity = this.quantity;
        }

        this.setSellIn(currentSellIn);
        this.setQuantity(currentQuantity);
    }
}
