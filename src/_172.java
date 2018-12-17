/**
 * 阶乘后的零
 *
 * @date 2018/12/17
 */
public class _172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n / 5 > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _172().trailingZeroes(25));
    }
}
