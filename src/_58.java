/**
 * 58. 最后一个单词的长度
 *
 * @date 2019/1/7
 */
public class _58 {

    /**
     * 关键词：逆序查找
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 从后往前，找到最后非空的index和其前一个' '的index
     **/

    //偷懒：直接调用 trim 和 lastindex
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(' ');
        return s.substring(index + 1).length();
    }

    //找到最后非空的index和其前一个' '的index
    public int lengthOfLastWord2(String s) {
        if (s.length() == 0)
            return 0;
        int i = s.length() - 1;
        int length = 0;

        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            --i;
        }
        return length;
    }
}
