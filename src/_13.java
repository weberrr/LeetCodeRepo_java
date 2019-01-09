import java.util.HashMap;

/**
 * 罗马数字转整数
 *
 * @date 2018/12/25
 */
public class _13 {

    /**
     * 关键词：哈希表
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：从左往右遍历罗马数字即可，如果当前罗马数字比下一个罗马数字小，则结果存储值减去当前罗马数字在哈希表中对应的值
     **/

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int num = 0;
        int next = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            num = map.get(s.charAt(i));
            next = map.get(s.charAt(i + 1));
            res += num >= next ? num : -num;
        }
        res += map.get(s.charAt(s.length() - 1));
        return res;
    }
}
