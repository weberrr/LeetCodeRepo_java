/**
 * Pow(x, n)
 *
 * @date 2019/1/14
 */
public class _50 {

    //递归
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
