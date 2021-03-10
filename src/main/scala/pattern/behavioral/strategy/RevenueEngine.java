package pattern.behavioral.strategy;

import pattern.behavioral.strategy.revenuestrategy.RevenueStrategy;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that makes the math for the fee of several items.
 */
public class RevenueEngine {
    private RevenueStrategy revenueStrategy;
    private AtomicInteger pricedItems = new AtomicInteger();

    public RevenueEngine(RevenueStrategy revenueStrategy) {
        this.revenueStrategy = revenueStrategy;
    }

    /**
     * Calculates the fee to add to a given {@link Item}
     * @param item the Item to calculate
     * @return a positive or zero value that represents the fee
     */
    public BigDecimal calculateFee(Item item){
        // increment the items priced by te engine on this session        
        pricedItems.incrementAndGet();
        // TODO fix the log
        System.out.println("Pricing item");
        
        return revenueStrategy.calculateFee(item);
    }

    public void setRevenueStrategy(RevenueStrategy revenueStrategy) {
        this.revenueStrategy = revenueStrategy;
    }

    /**
     * Get the total number of items priced by this engine on this session.
     * @return an integer greater or equal to 0.
     */
    public int getPricedItems() {
        return pricedItems.get();
    }
}
