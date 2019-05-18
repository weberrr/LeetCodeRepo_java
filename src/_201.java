/**
 * 201. 数字范围按位与
 *
 * @date 2019/5/18
 */
public class _201 {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m<<count;
    }
}
