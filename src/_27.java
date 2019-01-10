/**
 * 27. 移除元素
 *
 * @date 2019/1/5
 */
public class _27 {

    /**
     * 关键词：快慢双指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 通过快慢双指针，实现原地去定值
     * 当值等于val时，循环中的快指针++，慢指针不动
     * 当值不等于val时，慢指针赋值并++，循环中的快指针++
     **/

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
