import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @date 2018/12/20
 */
public class _3 {

    /**
     * 关键词：哈希表+滑动窗口双指针
     * 时间复杂度：o(2n)
     * 空间复杂度：o(min(m,n))
     * <p>
     * 思路：通过滑动窗口控制不重复子串的长度
     **/

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0, j = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
            } else {
                res = Math.max(res, j - i);
                set.remove(i++);
            }
        }
        return res;
    }

    /**
     * 改进：使用hashMap代替hashSet。
     * 如果在 [i,j) 范围内存在与 j' 重复的元素，
     * 不需要逐渐增加i，可以直接跳过 [i,j'] 内的元素，即 i = j'+ 1
     *
     * 时间复杂度：o(n)
     **/
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _3().lengthOfLongestSubstring2("abba"));
    }

}
