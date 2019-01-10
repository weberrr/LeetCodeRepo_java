/**
 * 28. 实现strStr()
 *
 * @date 2019/1/6
 */
public class _28 {

    /**
     * 关键词：单指针
     * 时间复杂度：o(nm)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 设定一个指针index,在haystack中从 0-(haystack.len-needle.len) 循环
     * 每次从指针index开始，遍历寻找needle，如果能找到，则返回index，如果找不全needle，则index+1再找
     **/

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
