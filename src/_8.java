/**
 * 字符串转换整数  (String to Integer (atoi))
 *
 * @date 2018/11/19
 */
public class _8 {

    /**
     * 关键词：情况分析
     * 时间复杂度：o(len(str))
     * 空间复杂度：o(1)
     * <p>
     * 思路：主要就是特殊情况比较多，需要处理好特殊情况
     **/

    public int myAtoi(String str) {
        int INT_MIN = -2147483648;
        String INT_STR = "2147483647";
        int INT_MAX = 2147483647;
        str = str.trim();
        if (str.equals("") ||
                ((str.charAt(0) == '-' || str.charAt(0) == '+') && str.length() == 1) ||
                (str.charAt(0) != '-' && str.charAt(0) != '+' && (str.charAt(0) < 48 || str.charAt(0) > 57)) ||
                (str.length() >= 2 && (str.charAt(0) == '-' || str.charAt(0) == '+') && (str.charAt(1) < 48 || str.charAt(1) > 57))) {
            return 0;
        } else {
            StringBuilder numStr = getNumber(str);
            if (numStr.length() == 0) {
                return 0;
            }
            String sign = str.charAt(0) == '-' ? "-" : "";
            int len = numStr.length();
            if (len > 10) {
                return sign.equals("-") ? INT_MIN : INT_MAX;
            } else if (len < 10) {
                return Integer.valueOf(sign + numStr);
            } else {
                long num = Long.valueOf(String.valueOf(numStr));
                if (sign.equals("-")) {
                    if (num - 1 > INT_MAX) {
                        return INT_MIN;
                    }
                } else {
                    if (num > INT_MAX) {
                        return INT_MAX;
                    }
                }
                return Integer.valueOf(sign + numStr);
            }
        }
    }

    public StringBuilder getNumber(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int asc = str.charAt(i);
            if (i == 0 && ((char) asc == '-' || (char) asc == '+')) {
                continue;
            }
            if (asc >= 48 && asc <= 57) {
                if (res.length() == 0 && asc == 48) {
                    continue;
                }
                res.append((char) asc);
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _8 test = new _8();
        System.out.println(test.myAtoi("-2147483647"));
    }
}
