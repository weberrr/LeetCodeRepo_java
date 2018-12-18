import java.util.Arrays;
import java.util.List;

/**
 * 找不同
 *
 * @date 2018/12/18
 */
public class _389 {
    public char findTheDifference(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return tChar[i];
            }
        }
        return tChar[tChar.length - 1];
    }

    public char findTheDifference2(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            c ^= t.charAt(i);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new _389().findTheDifference("abd", "cdba"));
    }
}
