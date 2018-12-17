/**
 * 阶乘函数后K个零
 *
 * @date 2018/12/17
 */
public class _793 {
    // K = (n / 5) + (n / 25) + (n / 125) + ... + n / (5^k)
    // K <= n / 4
    public int preimageSizeFZF(int K) {
        for (long n = (long) 4 * K; ; n++) {
            if (trailingZeroes(n) == K) {
                return 5;
            } else if (trailingZeroes(n) > K) {
                return 0;
            }
        }
    }

    public int trailingZeroes(long n) {
        int res = 0;
        while (n / 5 > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _793().preimageSizeFZF(1000000000));
    }
}
