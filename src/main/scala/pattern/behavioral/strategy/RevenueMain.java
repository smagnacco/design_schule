package pattern.behavioral.strategy;

import pattern.behavioral.strategy.Item;
import pattern.behavioral.strategy.ItemType;
import pattern.behavioral.strategy.RevenueEngine;
import pattern.behavioral.strategy.revenuestrategy.FixedStrategy;
import pattern.behavioral.strategy.revenuestrategy.MarginStrategy;
import pattern.behavioral.strategy.revenuestrategy.MarketShareStrategy;
import pattern.behavioral.strategy.revenuestrategy.PercentageStrategy;

import java.math.BigDecimal;

public class RevenueMain {
    public static void main(String[] args) {
        RevenueEngine engine = new RevenueEngine(new FixedStrategy(BigDecimal.valueOf(30)));
        Item item = new Item(BigDecimal.valueOf(100), BigDecimal.valueOf(10), BigDecimal.valueOf(5), ItemType.PUBLIC);
        
        BigDecimal fee = engine.calculateFee(item);
        // 30
        System.out.println("FixedStrategy: " + fee);
        
        engine.setRevenueStrategy(new MarginStrategy());
        fee = engine.calculateFee(item);
        // 100 + (10 * 2) = 120
        System.out.println("MarginStrategy: " + fee);
        
        engine.setRevenueStrategy(new MarketShareStrategy());
        fee = engine.calculateFee(item);
        // 100 + 10 - 5 = 105
        System.out.println("MarketShareStrategy: " + fee);

        engine.setRevenueStrategy(new PercentageStrategy(BigDecimal.valueOf(0.3)));
        fee = engine.calculateFee(item);
        // 100 * 0,3 = 130
        System.out.println("PercentageStrategy: " + fee);

        System.out.println("Priced " + engine.getPricedItems() + " items.");
    }
}
