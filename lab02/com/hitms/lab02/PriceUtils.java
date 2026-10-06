package com.hitms.lab02;

/**
 * Helper methods for working with a list of item prices.
 */
public final class PriceUtils {

    /** Sample item prices used by the demo. */
    private static final double[] SAMPLE_PRICES = {250.0, 99.5, 120.5};

    /** Prevents instantiation of this utility class. */
    private PriceUtils() {
    }

    /**
     * Returns the sum of a list of item prices.
     *
     * @param prices the item prices
     * @return the total of all prices
     */
    public static double total(final double[] prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price; // accumulate running total
        }
        return sum;
    }

    /**
     * Returns the average of a list of item prices.
     *
     * @param prices the item prices
     * @return the mean price
     */
    public static double average(final double[] prices) {
        return total(prices) / prices.length;
    }

    /**
     * Demonstrates the price helpers.
     *
     * @param args command line arguments (not used)
     */
    public static void main(final String[] args) {
        System.out.println("Total: " + total(SAMPLE_PRICES));
        System.out.println("Average: " + average(SAMPLE_PRICES));
    }
}
