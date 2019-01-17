/**
 * 67. 二进制求和
 *
 * @date 2019/1/17
 */
public class _67 {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        char bit = '0';
        int val, i, j;
        for (i = ac.length - 1, j = bc.length - 1; i >= 0 && j >= 0; i--, j--) {
            val = ac[i] + bc[j] + bit - 3 * '0';
            bit = (val >= 2 ? '1' : '0');
            sb.append(val % 2);
        }
        for (; j >= 0; j--) {
            if (bit == '1') {
                bit = (bc[j] == '1' ? '1' : '0');
                sb.append((bc[j] == '0' ? '1' : '0'));
            } else {
                sb.append(bc[j]);
            }
        }
        if (bit == '1') sb.append('1');
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _67().addBinary("11", "1"));
    }
}
