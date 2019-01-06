/**
 * 29. 两数相除
 *
 * @date 2019/1/6
 */
public class _29 {

    public int divide(int dividend, int divisor) {
        long divid = (long) dividend;
        long divi = (long) divisor;
        if (divisor == 0) return 0;
        if (divi == 1) return (int) divid;
        if (divi == -1) return divid <= Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) -divid;
        boolean flag = true;
        if (divid < 0) {
            divid = -divid;
            flag = false;
        }
        if (divi < 0) {
            divi = -divi;
            flag = !flag;
        }
        long res = 0, temp, cnt;
        while (divi <= divid) {
            cnt = 1;
            temp = divi;
            while (temp <= divid) {
                temp <<= 1;
                cnt <<= 1;
            }
            res += (cnt >> 1);
            divid -= (temp >> 1);
        }
        return flag ? (int) res : (int) -res;
    }
}
