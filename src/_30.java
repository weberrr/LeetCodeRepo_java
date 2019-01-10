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

    /**
     * 关键词：哈希表 + 滑动窗口
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 将words数组中的字符串存入hashmap，值为出现次数。
     * 然后开始遍历字符串s，外层循环从0到word[0].length-1，(对不同的开始做一遍遍历 比如wlen=5, 则单词划分可能是 0 5 10 ;也可能是 1 6 11）
     * 内层循环从i到最后，每次增加一个word的长度，维持一个滑动窗口，左右边界都只向右移动，
     * 每次先移动right，窗口大小表示匹配到的word个数，随着移动而增大或减小。移动right，如果map中存在当前字符串，修改map中对应word的个数
     * 一旦发现当前需要修改的个数已经为0，说明出现了多余的字符串，窗口需要更新，这时候开始移动窗口左边界，
     * 直到左边界滑过与当前字符串相同的字符串，滑动左边界的同时把map中对应字符串的个数加回来。 
     * 如果当前map中找不到cur（当前字符串），说明cur之前的窗口已经没用了，重置窗口大小为0，将left到right的map值加回来，
     * 然后从下一个位置重新开始匹配。
     * tip：每次记得维护窗口的同时也维护hashMap，将之前丢掉的单词数加回来
     **/

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
