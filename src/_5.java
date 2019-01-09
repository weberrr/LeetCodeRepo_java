/**
 * 最长回文子串
 *
 * @date 2018/12/20
 */
public class _5 {

    /**
     * 关键词：回文子串 + 中心扩展算法
     * 时间复杂度：o((2n-1)*n) = o(n^2)
     * 空间复杂度：o(1)
     * <p>
     * 思路：一个字符串共有 n+(n-1)=2n-1 个中心，对每个中心，做往左右的对称扩展，如果左右char相等，则回文子串len+=2
     **/

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new _5().longestPalindrome("babad"));
    }
}
