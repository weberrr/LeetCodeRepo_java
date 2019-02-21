/**
 * 91. 解码方法
 *
 * @date 2019/2/21
 */
public class _91 {

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        dp[0] = chars[0] == '0' ? 0 : 1;
        if (len == 1) return dp[0];
        int k = chars[0] > '0' && chars[1] > '0' ? 1 : 0;
        dp[1] = k + (chars[0] == '1' || (chars[0] == '2' && chars[1] <= '6') ? 1 : 0);
        for (int i = 2; i < len; i++) {
            if (chars[i] != '0') {
                dp[i] = dp[i - 1];
            }
            if (chars[i - 1] == '1' || chars[i - 1] == '2' && chars[i] <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        System.out.println(new _91().numDecodings("110"));
    }
}
