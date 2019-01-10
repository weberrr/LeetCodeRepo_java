/**
 * 26. 删除排序数组中的重复项
 *
 * @date 2019/1/5
 */
public class _26 {

    /**
     * 关键词：快慢双指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 通过快慢双指针，实现原地去重
     * 当两个值相等时，循环的快指针++，慢指针不动
     **/

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
