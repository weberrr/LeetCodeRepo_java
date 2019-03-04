/**
 * 87. 扰乱字符串
 *
 * @date 2019/3/4
 */
public class _87 {

    //法1：递归
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        if (len1 == 1) return s1.charAt(0) == s2.charAt(0);
        int[] cnt = new int[256];
        for (int i = 0; i < len1; i++) {
            cnt[s1.charAt(i)]++;
            cnt[s2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (cnt[i] != 0) return false;
        }
        for (int i = 0; i < len1 - 1; i++) {
            if ((isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1)) && isScramble(s1.substring(i + 1), s2.substring(i + 1))) ||
                    (isScramble(s1.substring(0, i + 1), s2.substring(len2 - i - 1)) && isScramble(s1.substring(i + 1), s2.substring(0, len2 - i - 1)))) {
                return true;
            }
        }
        return false;
    }

    //法2：动态规划
    //dp[i][j][k] 表示 s1从i开始，s2从j开始，k长度是否满足
    //dp[i][j][k] |= dp[i][j][l] && dp[i+l][j+l][k-l]|| dp[i][j+k-l][l] && dp[i+l][j][k-l]


    public static void main(String[] args) {
        System.out.println(new _87().isScramble("abcde", "caebd"));
    }
}
