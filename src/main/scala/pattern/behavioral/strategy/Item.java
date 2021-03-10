package pattern.behavioral.strategy;

import java.math.BigDecimal;

public class Item {
    private BigDecimal providerPrice;
    private BigDecimal otherCost;
    private BigDecimal incentives;
    private ItemType itemType;

    public Item(BigDecimal providerPrice, BigDecimal otherCost, BigDecimal incentives, ItemType itemType) {
        this.providerPrice = providerPrice;
        this.otherCost = otherCost;
        this.incentives = incentives;
        this.itemType = itemType;
    }

    public BigDecimal getProviderPrice() {
        return providerPrice;
    }

    public BigDecimal getOtherCost() {
        return otherCost;
    }

    public BigDecimal getIncentives() {
        return incentives;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
