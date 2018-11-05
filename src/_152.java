/**
 * 乘积最大子序列(Maximum Product Subarray)
 *
 * @date 2018/10/31
 */
public class _152 {

    //记录连乘到当前元素的最大值/最小值
    public int maxProduct(int[] nums) {
        int l = nums.length;
        int max = nums[0];
        int maxLast = nums[0];
        int minLast = nums[0];
        int maxCur = nums[0];
        int minCur = nums[0];
        for (int i = 1; i < l; i++) {
            maxCur = Math.max(nums[i],Math.max(maxLast*nums[i],minLast*nums[i]));
            minCur = Math.min(nums[i],Math.min(maxLast*nums[i],minLast*nums[i]));
            maxLast = maxCur;
            minLast = minCur;
            max = Math.max(max,maxCur);
        }
        return max;
    }

    public static void main(String[] args) {
        _152 t = new _152();
        int[] num = {2, 3, -2, 4};
        System.out.println(t.maxProduct(num));
    }

}
