/**
 * 28. 实现strStr()
 *
 * @date 2019/1/6
 */
public class _28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        char[] raw = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int ret = -1;
        int index = 0;
        while (index <= raw.length - need.length) {
            int x = 0;
            while (x < need.length && raw[x + index] == need[x]) {
                x++;
            }
            if (x == need.length) {
                return index;
            }
            index++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _28().strStr("mississippi", "issipi"));
    }
}
