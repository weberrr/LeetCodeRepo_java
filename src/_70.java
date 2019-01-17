/**
 * 70. 爬楼梯
 *
 * @date 2019/1/17
 */
public class _70 {

    //dp
    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }
    }
}
