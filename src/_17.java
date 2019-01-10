import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @date 2019/1/3
 */
public class _17 {

    /**
     * 关键词：哈希表 + 回溯
     * 时间复杂度：o(k^n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：哈希表 + 回溯（选择、条件、终止）
     * 选择：数字2-9
     * 条件：无
     * 终止：循环的index达到字符串length，将子串加入list
     *
     **/

    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return letterCombinations(digits, new ArrayList<>(), map, "", 0);
    }

    private List<String> letterCombinations(String digits, List<String> list, HashMap<Integer, String> map, String sub, int index) {
        if (index == digits.length()) {
            if (sub.length() != 0) list.add(sub);
        } else {
            String temp = map.get(Integer.valueOf(digits.substring(index, index + 1)));
            for (char c : temp.toCharArray()) {
                letterCombinations(digits, list, map, sub + c, index + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new _17().letterCombinations("23"));
    }
}
