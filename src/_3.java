import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangz
 * @date 2018/12/20
 */
public class _3 {

    // O(2n)  hashset 双指针
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

    //O(n)  hashmap 双指针
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
