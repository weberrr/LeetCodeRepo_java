/**
 * 231. 2的幂
 *
 * @date 2019/5/18
 */
public class _231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new _231().isPowerOfTwo(0));
    }
}
