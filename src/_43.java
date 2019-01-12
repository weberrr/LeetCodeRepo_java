/**
 * 43. 字符串相乘
 *
 * @date 2019/1/12
 */
public class _43 {

    //法1：直接一位一位乘
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int multiplier = num1.charAt(i) - '0';
            if (multiplier == 0) continue;
            StringBuilder cur = new StringBuilder();
            int count = num1.length() - 1 - i;
            for (int j = 0; j < count; j++) {
                cur.append(0);
            }
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int multiplicand = num2.charAt(j) - '0';
                int multiply = multiplier * multiplicand + carry;
                cur.append(multiply % 10);
                carry = multiply / 10;
            }
            if (carry != 0) cur.append(carry);
            carry = 0;

            StringBuilder sum = new StringBuilder();
            for (int resIndex = 0, curIndex = 0; resIndex < res.length() || curIndex < cur.length(); ) {
                int temp = carry;
                if (curIndex < cur.length()) temp += cur.charAt(curIndex++) - '0';
                if (resIndex < res.length()) temp += res.charAt(resIndex++) - '0';
                sum.append(temp % 10);
                carry = temp / 10;
            }
            if (carry != 0) sum.append(carry);
            res = sum.toString();
        }
        StringBuffer sb = new StringBuffer(res);
        return sb.reverse().toString();
    }

    //优化 法2：int数组存储每位的乘积中间值 最后拿数组进一步计算
    public String multiply2(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty()
                || (num1.length() == 1 && num1.charAt(0) == '0')
                || (num2.length() == 1 && num2.charAt(0) == '0'))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2 + 1];
        for (int i = 0; i < len1; i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < len2; j++) {
                int b = num2.charAt(j) - '0';
                ans[len1 + len2 - i - j - 2] += a * b;
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < len1 + len2; i++) {
            res.append(ans[i] % 10);
            ans[i + 1] += ans[i] / 10;
        }
        String result = res.reverse().toString();
        if (result.startsWith("0"))
            result = result.substring(1, len1 + len2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _43().multiply("9133", "0"));
    }
}
