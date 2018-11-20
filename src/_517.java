import java.util.Arrays;

/**
 * Super Washing Machines（超级洗衣机）
 *
 * @date 2018/11/16
 */
public class _517 {
    //lc : m[i]需要从左边获取的衣服数量
    //rc ：m[i]需要从右边获取的衣服数量
    //选lc和rc的最小值
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int num : machines) {
            sum += num;
        }
        if (sum % machines.length != 0) {
            return -1;
        } else {
            int ave = sum / machines.length;
            int max = 0;
            int tempSum = 0;
            for (int i = 0; i < machines.length; i++) {
                int lc = tempSum - ave * i;
                tempSum += machines[i];
                int rc = sum - tempSum - ave * (machines.length - 1 - i);
                // 两边都需要中间提供，中间一次只能移动一步，故求和
                if (lc < 0 && rc < 0) {
                    max = Math.max(max, Math.abs(lc + rc));
                } else {
                    max = Math.max(max, Math.max(Math.abs(lc), Math.abs(rc)));
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        _517 test = new _517();
        int[] machines = {9, 1, 8, 8, 9};
        System.out.println(test.findMinMoves(machines));
    }
}
