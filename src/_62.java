/**
 * 62. 不同路径
 *
 * @date 2019/1/17
 */
public class _62 {

    //dp
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else if (i == m - 1) {
                    dp[i][j] = dp[i][j + 1];
                } else if (j == n - 1) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    //回溯： 用例:m=100，n=3 会超时
    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) return 0;
        else if (m == 1 || n == 1) return 1;
        else {
            return uniquePaths2(m - 1, n) + uniquePaths2(m, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _62().uniquePaths(100, 3));
    }
}
