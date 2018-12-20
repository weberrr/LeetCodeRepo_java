/**
 * 最长回文子串
 *
 * @date 2018/12/20
 */
public class _5 {

    //中心扩展算法  共有2n-1个中心
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
            left--;right++;
        }
        left++;right--;
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new _5().longestPalindrome("babad"));
    }
}
