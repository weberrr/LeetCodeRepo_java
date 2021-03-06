import java.util.*;

/**
 * 字母异位词分组(Group Anagrams)
 *
 * @date 2018/11/26
 */
public class _49 {

    /**
     * 关键词：哈希表
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 建立哈希表，每次遇到没存储过的有序chars，就添加新map
     * 遇到存储过的有序chars，就放入对应的list中
     **/

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = Arrays.toString(chars);
            if (map.containsKey(temp)) {
                map.get(temp).add(strs[i]);
            } else {
                List<String> listTemp = new ArrayList<>();
                listTemp.add(strs[i]);
                map.put(temp, listTemp);
            }

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new _49().groupAnagrams(strs));
    }
}
