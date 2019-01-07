/**
 * 58. 最后一个单词的长度
 *
 * @date 2019/1/7
 */
public class _58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(' ');
        return s.substring(index + 1).length();
    }

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
