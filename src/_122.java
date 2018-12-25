/**
 * 买卖股票的最佳时机 II
 *
 * @date 2018/12/25
 */
public class _122 {

    //贪心
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int differ = prices[i + 1] - prices[i];
            profit += differ > 0 ? differ : 0;
        }
        return profit;
    }


}
