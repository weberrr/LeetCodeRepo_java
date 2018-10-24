/**
 * 在LR字符串中交换相邻字符（Swap Adjacent in LR String）
 * <p>
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 *
 * @date 2018/10/19
 */
public class _777 {
    //从左到右对比start和end的R，如果相等继续，不相等，如果遇到start的R和end的X，则一直把R往后找，找到遇到L或也是R时交换
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
