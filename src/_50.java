/**
 * Pow(x, n)
 *
 * @date 2019/1/14
 */
public class _50 {

    /**
     * 关键词：递归
     * 时间复杂度：o(logn)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 如果n<0，则x取 1/x n取-n
     * 之后递归调用自身，pow(x*x,n/2)
     **/

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        // n = −2^31时，不能取-n 越界了
        if (n == Integer.MIN_VALUE) return 1 / x * myPow(x, n + 1);
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(new _50().myPow(2.00000, -2));
    }

}
