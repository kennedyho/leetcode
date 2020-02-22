/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
*/

public class BestTimeToSellStock {
    private static int maxProfit(int[] prices) {

        // Array of prices need to have at least two prices to begin with
        if (prices.length < 2) {
            throw new IllegalArgumentException("Not enough prices to calculate maximum profit.");
        }
        // Initialize as 0 for maximum profit so far and current maximum profit
        int maxProfitSoFar = 0;
        int currentMaxProfit = 0;

        for (int i = 1; i < prices.length; ++i) {
            // Accumulate the day by day profit.
            currentMaxProfit += (prices[i] - prices[i - 1]);
            // Once the accumulate profit turns negative, reset it to 0.
            // When no profit can be made, zero is returned. Negative profit is not allowed in this question.
            if (currentMaxProfit < 0) {
                currentMaxProfit = 0;
            }
            // Get the maxProfitSoFar by making a comparison between the current maximum profit and the maxProfitSoFar
            maxProfitSoFar = Math.max(maxProfitSoFar, currentMaxProfit);
        }
        return maxProfitSoFar;
    }

    public static void main(String[] args) {

    }
}
