/**
 * 65. 有效数字
 *
 * @date 2019/1/17
 */
public class _65 {

    //1.数字前后可以有空格
    //2. '.'仅可出现一次，前面可无数字，后面一定要有
    //3. 'e'仅可出现一次，前后必须有数字，后面数字必须为整数(无'.')
    //4. '+/-' 在e前后都仅可出现一次，且要在数字前
    //5. 其他字符只能为 0-9
    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == ' ') i++; //去除前面空格
        if (i < chars.length && (chars[i] == '+' || chars[i] == '-')) i++;
        boolean digit = false, dot = false, exp = false;
        while (i < chars.length) {
            if (chars[i] == '.' && !dot) dot = true; // '.'不能出现2次，'.'前面能够没有数字
            else if (chars[i] == 'e' && !exp && digit) { // 'e'不能出现2次，'e'前面必须有数字
                dot = exp = true;
                if (i < chars.length - 1 && (chars[i + 1] == '+' || chars[i + 1] == '-')) {
                    i++;
                }
                if (i >= chars.length - 1 || !(chars[i + 1] >= '0' && chars[i + 1] <= '9')) {
                    return false;
                }
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                digit = true;
            } else {
                break;
            }
            i++;
        }
        while (i < chars.length && chars[i] == ' ') i++; //去除后面空格
        return digit && i == chars.length;
    }

    // 正则表达式 较慢
    public boolean isNumber2(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println(new _65().isNumber("0e1"));
    }
}
