/**
 * 29. 两数相除
 *
 * @date 2019/1/6
 */
public class _29 {

    /**
     * 关键词：数学 特殊情况处理
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * int的取值范围为 -2147483648 2147483647 所以注意除以1的特殊情况
     * 因为不使用乘法、除法和 mod 运算符
     * 所以先处理特殊值（直接返回特值）、再处理符号（设置flag将正负号统一为正号）
     * 再通过2^k、2^k-1 计算 除数右移 多少个 2^k 得到一个 被除数范围内最大的值
     * 以此类推 最后将这些 2^k 相加
     **/

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

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE+ " " + Integer.MAX_VALUE);
    }
}
