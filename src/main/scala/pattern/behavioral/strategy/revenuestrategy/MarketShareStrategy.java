package pattern.behavioral.strategy.revenuestrategy;

import pattern.behavioral.strategy.Item;

import java.math.BigDecimal;

public class MarketShareStrategy implements RevenueStrategy{
    public BigDecimal calculateFee(Item item){
        return item.getProviderPrice().add(item.getOtherCost().subtract(item.getIncentives())); 
    }
}
