import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 与所有单词相关联的字串
 *
 * @date 2019/1/8
 */
public class _30 {

    //利用哈希表和滑动窗口可以以O(n)的时间复杂度解决问题
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int sLen = s.length(), wLen = words[0].length(), wsLen = words.length;
        if (sLen < wLen * wsLen) return res;

        Map<String, Integer> map = new HashMap<>(); // 建立map 存储 word及出现次数
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (int i = 0; i < wLen; i++) {
            int left = i, right = i, window = 0; // 窗口大小和左右边界
            while (right + (wsLen - window) * wLen <= sLen && right + wLen <= sLen) {
                String cur = s.substring(right, right + wLen);
                if (map.containsKey(cur)) {
                    int cnt = map.get(cur);
                    if (cnt > 0) {
                        window++;
                        map.put(cur, cnt - 1);
                    } else { //map 当前字符串个数为0 说明出现了重复字符
                        String removed = s.substring(left, left + wLen);
                        while (!removed.equals(cur)) {
                            map.put(removed, map.get(removed) + 1);
                            left += wLen;
                            window--;
                            removed = s.substring(left, left + wLen);
                        }
                        left += wLen;
                    }
                    if (window == wsLen) res.add(left);
                } else {
                    window = 0;
                    while (left < right) {
                        String removed = s.substring(left, left + wLen);
                        map.put(removed, map.get(removed) + 1);
                        left += wLen;
                    }
                    left += wLen;
                }
                right += wLen;// 窗口往右拓展一个字符串的长度
            }
            //恢复map
            while (left < right) {
                String removed = s.substring(left, left + wLen);
                map.put(removed, map.get(removed) + 1); // 恢复移除字符串的个数
                left += wLen;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(new _30().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(new _30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }
}
