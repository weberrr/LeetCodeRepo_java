/**
 * 44. 通配符匹配
 *
 * @date 2019/1/12
 */
public class _44 {

    /**
     * 关键词：双指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 记录下star index 和 i index的 下标，每次没匹配上的时候，p返回star_index +1  i返回 ++i_index
     **/

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int i_index = 0, star_index = -1; //需记录star的下标和i_index的下标
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star_index = j;
                i_index = i;
                j++;
            } else if (star_index != -1) {
                i_index++;
                i = i_index;
                j = star_index + 1;
            } else
                return false;
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        System.out.println(new _44().isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b"));
        System.out.println(new _44().isMatch("aa", "*"));

    }

}
