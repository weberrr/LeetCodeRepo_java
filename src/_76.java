import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 *
 * @date 2019/2/28
 */
public class _76 {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int minLen = s.length() + 1;  //定义滑动窗口
        int count = 0;
        for (; end < s.length(); end++) {
            char temp = s.charAt(end);
            if (map.containsKey(temp)) {
                count = map.get(temp) > 0 ? count + 1 : count;
                map.put(temp, map.get(temp) - 1);
            }
            while (count == t.length()) {
                if (end - start < minLen) {
                    minEnd = end;
                    minStart = start;
                    minLen = minEnd - minStart;
                }
                char c = s.charAt(start);
                if (map.containsKey(c)) {
                    if (map.get(c) >= 0) count--;
                    map.put(c, map.get(c) + 1);
                }
                start++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(minStart, minEnd + 1);
    }
}
