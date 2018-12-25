import java.util.HashMap;

/**
 * 罗马数字转整数
 *
 * @date 2018/12/25
 */
public class _13 {

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
