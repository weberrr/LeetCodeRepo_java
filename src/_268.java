/**
 * 268. 缺失数字
 *
 * @date 2019/5/18
 */
public class _268 {

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

}
