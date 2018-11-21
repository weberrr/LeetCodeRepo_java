/**
 * 最长回文子序列(Longest Palindromic Subsequence)
 *
 * @date 2018/11/21
 */
public class _516 {
    //动态规划
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int step = 1; step < n; step++) {
            for (int i = 0; i < n - step; i++) {
                int j = i + step;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        _516 test = new _516();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(test.longestPalindromeSubseq(s));
    }

}
