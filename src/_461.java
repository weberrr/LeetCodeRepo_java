/**
 * 汉明距离
 *
 * @date 2018/12/5
 */
public class _461 {

    //位运算
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int sum = 0;
        while (res != 0) {
            sum++;
            res = res & (res - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new _461().hammingDistance(1, 2));
    }
}
