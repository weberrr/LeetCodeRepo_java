/**
 * 正则表达式匹配（Regular Expression Matching）
 *
 * @date 2018/11/19
 */
public class _10 {

    /**
     * 关键词：回溯 + 正则
     * 时间复杂度：o(log(s))
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 回溯问题三要素：选择 条件 终止
     * 选择：.  *  char
     * 终止：p.len<=1 时，终止
     * 条件：p.len>=2时 看p的下一个是否为*
     * 为 * ：如果能和s[0]匹配, s.substr(1) 或 p.substr(2)(也可能不用这个x*符号) 再做递归 ；不匹配则 p.substr(2) 做递归
     * 不为 * ： 则和s[o] 匹配 如果匹配 s.substr(1)和p.substr(1) 做递归
     **/

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // pLen = 0
        if (pLen == 0) {
            return sLen == 0;
        }
        // pLen = 1
        char c = p.charAt(0);
        if (pLen == 1) {
            return (sLen == 1 && (s.charAt(0) == c || isPoint(c)));
        }
        // pLen >=2
        char next = p.charAt(1);

        if (isLetter(next) || isPoint(next)) {
            return sLen != 0 && ((isLetter(c) && c == s.charAt(0)) || isPoint(c)) && isMatch(s.substring(1), p.substring(1));
        } else {
            // next = *
            if (sLen != 0 && (isLetter(c) && c == s.charAt(0) || isPoint(c))) {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            }
            return isMatch(s, p.substring(2));
        }
    }

    private boolean isLetter(char c) {
        return c <= 'z' && c >= 'a';
    }

    private boolean isPoint(char c) {
        return c == '.';
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "aaa";
        _10 test = new _10();
        System.out.println(test.isMatch(s, p));
    }

}
