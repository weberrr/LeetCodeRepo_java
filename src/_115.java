/**
 * Distinct Subsequences（不同的子序列）
 *
 * @date 2018/11/15
 */
public class _115 {

    //dp[i][j] = dp[i-1][j] + T[i-1]==S[j-1]? dp[i-1][j-1]:0
    public int numDistinct(String s, String t) {

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int sLen = s.length();
        int tLen = t.length();

        int[][] dp = new int[tLen + 1][sLen + 1];
        for (int i = 0; i < tLen + 1; i++) {
            for (int j = 0; j < sLen + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + (sChar[i - 1] == tChar[j - 1] ? dp[i - 1][j - 1] : 0);
                }
            }
        }
        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        _115 test = new _115();
        String S = "rabbbit", T = "rabbit";
        System.out.println(test.numDistinct(S, T));
    }

}
