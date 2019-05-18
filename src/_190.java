/**
 * 190. 颠倒二进制位
 *
 * @date 2019/5/18
 */
public class _190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += ((1 & (n >> i)) << (31 - i));
        }
        return res;
    }
}
