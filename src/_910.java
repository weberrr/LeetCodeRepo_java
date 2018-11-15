import java.util.*;

/**
 * 最小差值（Smallest Range II）
 * <p>
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * @date 2018/10/22
 */
public class _910 {
    //-k +k 可转换为 0，+2k；把数组排序，然后遍历计算每个数+2k后最大值最小值以及最小差值
    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int min = A[0];
        int max = A[n - 1];
        int res = max - min;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, A[i] + 2 * K);
            min = Math.min(A[0] + 2 * K, A[i + 1]);
            res = Math.min(res, max - min);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1};
        System.out.println(smallestRangeII(A, 0));
    }

}
