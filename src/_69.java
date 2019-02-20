/**
 * 69. x 的平方根
 *
 * @date 2019/2/1
 */
public class _69 {

    //mid*mid 会溢出
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return x <= 1 ? x : left - 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new _69().mySqrt(i));
        }
    }
}
