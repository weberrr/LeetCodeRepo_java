/**
 * 猜大小（Guess Number Higher or Lower）
 * <p>
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 *
 * @date 2018/10/19
 */
public class _375 {
    //做一个遍历，递归获得每个从i到j的最小代价
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        return cost(dp, 1, n);
    }

    public int cost(int[][] dp, int start, int end) {
        int res = 999999;
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        for (int i = start; i < end + 1; i++) {
            int temp = i + max(cost(dp, start, i - 1), cost(dp, i + 1, end));
            if (temp < res) {
                res = temp;
            }
        }
        dp[start][end] = res;
        return res;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        _375 test = new _375();
        System.out.println(test.getMoneyAmount(20));
    }
}
