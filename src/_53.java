/**
 * 53. 最大子序和
 *
 * @date 2019/1/7
 */
public class _53 {

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
