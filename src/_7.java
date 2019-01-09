/**
 * 整数反转
 *
 * @date 2018/12/20
 */
public class _7 {

    /**
     * 关键词：数学
     * 时间复杂度：o(log(x)) 即x的数字长度
     * 空间复杂度：o(1)
     * <p>
     * 思路：每次模取一个数 放在 结果变量中 注意 int范围是 2147483647 到 -2147483648
     **/

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {

        System.out.println(new _7().reverse(1534236469));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
