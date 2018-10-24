/**
 * Swap Adjacent in LR String
 *
 * @author wangze
 * @date 2018/10/19
 */
public class _777 {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        StringBuilder s = new StringBuilder(start);
        StringBuilder e = new StringBuilder(end);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == e.charAt(i)) {
                continue;
            } else if (s.charAt(i) == 'R' && e.charAt(i) == 'X') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'R') {
                        char temp = s.charAt(i);
                        s.setCharAt(i, s.charAt(j));
                        s.setCharAt(j, temp);
                        break;
                    } else if (s.charAt(j) == 'L') {
                        break;
                    }
                }
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == e.charAt(i)) {
                continue;
            } else if (s.charAt(i) == 'L' && e.charAt(i) == 'X') {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == 'X') {
                        char temp = s.charAt(i);
                        s.setCharAt(i, s.charAt(j));
                        s.setCharAt(j, temp);
                        break;
                    } else if (s.charAt(j) == 'R') {
                        break;
                    }
                }
            }
        }
        System.out.print(s + " " + e);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != e.charAt(i)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        _777 t = new _777();
        String s = "XXXXXLXXXX";
        String r = "XXXLXXXXXX";
        System.out.print(t.canTransform(s, r));

    }
}
