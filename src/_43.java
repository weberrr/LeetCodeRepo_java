/**
 * 43. 字符串相乘
 *
 * @date 2019/1/12
 */
public class _43 {

    /**
     * 关键词：数组存储中间值
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 把一个数的每一位的数拿出来和另一个数做乘积，并且记录乘积结果在数组ans[]中，
     * 之后再把数组ans的每位进行进位更新 res.add(ans[i]%10) ans[i+1] += ans[i]/10
     **/

    public String multiply(String num1, String num2) {
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
