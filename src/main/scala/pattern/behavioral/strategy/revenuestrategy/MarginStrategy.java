package pattern.behavioral.strategy.revenuestrategy;

import pattern.behavioral.strategy.Item;

import java.math.BigDecimal;

public class MarginStrategy implements RevenueStrategy {
    public BigDecimal calculateFee(Item item) {
        return item.getProviderPrice().add(item.getOtherCost().multiply(BigDecimal.valueOf(2)));
    }
}
