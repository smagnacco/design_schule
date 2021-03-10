package pattern.behavioral.strategy.revenuestrategy;

import pattern.behavioral.strategy.Item;

import java.math.BigDecimal;

public class FixedStrategy implements RevenueStrategy{
    private BigDecimal fixedFee;
    
    public BigDecimal calculateFee(Item item){
        return fixedFee;
    }

    public FixedStrategy(BigDecimal fixedFee) {
        this.fixedFee = fixedFee;
    }
}
