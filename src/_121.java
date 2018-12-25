/**
 * 买卖股票的最佳时机
 *
 * @date 2018/12/25
 */
public class _121 {

    //动态规划：前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _121().maxProfit(new int[]{2,1}));
    }
}
