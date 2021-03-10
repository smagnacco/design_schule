package pattern.behavioral.strategy.revenuestrategy;

import pattern.behavioral.strategy.Item;

import java.math.BigDecimal;

/**
 * Interface that calculates the fee for a given {@link item}
 */
public interface RevenueStrategy {
    BigDecimal calculateFee(Item item);
}
