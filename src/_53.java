/**
 * 53. 最大子序和
 *
 * @date 2019/1/7
 */
public class _53 {

    /**
     * 关键词：Kadane算法
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 最大子序和[i,j]，对任意的k可以分解为[i,k],[k,j]>0 可反证
     * 所以如果累和sum<0 则从新记子序和
     * 并通过res更新记录的最大值
     **/

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int n : nums) {
            if (sum > 0) {
                sum += n;
            } else {
                sum = n;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
