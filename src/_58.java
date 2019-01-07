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
}
