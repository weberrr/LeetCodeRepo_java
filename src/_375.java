/**
 * Guess Number Higher or Lower
 *
 * @author wangze
 * @date 2018/10/19
 */
public class _375 {
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        return cost(dp, 1, n);
    }

    public int cost(int[][] dp, int start, int end) {
        int res = 999999;
        if(start>=end){
            return 0;
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
        for (int i = start; i < end+1; i++) {
            int temp =  i+ max(cost(dp, start, i - 1), cost(dp, i+1, end));
            if (temp<res){
                res = temp;
            }
        }
        dp[start][end] = res;
        return res;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }

    public static void main(String[] args) {
        _375 test = new _375();
        System.out.println(test.getMoneyAmount(20));
    }
}
