/**
 * 正则表达式匹配（Regular Expression Matching）
 *
 * @date 2018/11/19
 */
public class _10 {

    //回溯
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
        String s = "aab";
        String p = "c*a*b";
        _10 test = new _10();
        System.out.println(test.isMatch(s, p));
    }

}
