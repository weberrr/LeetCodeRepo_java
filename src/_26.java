/**
 * 26. 删除排序数组中的重复项
 *
 * @date 2019/1/5
 */
public class _26 {

    //快慢双指针：实现原地更改
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
