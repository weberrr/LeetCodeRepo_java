/**
 * 27. 移除元素
 *
 * @date 2019/1/5
 */
public class _27 {

    //快慢双指针
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
