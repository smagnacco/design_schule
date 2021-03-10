package pattern.behavioral.strategy.revenuestrategy;

import pattern.behavioral.strategy.Item;

import java.math.BigDecimal;

public class PercentageStrategy implements RevenueStrategy{
    private BigDecimal percentage;
    
    public BigDecimal calculateFee(Item item){
        return item.getProviderPrice().multiply(percentage);
    }

    public PercentageStrategy(BigDecimal percentage) {
        this.percentage = percentage.add(BigDecimal.ONE);
    }
}
