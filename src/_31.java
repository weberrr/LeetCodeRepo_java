import java.util.Arrays;

/**
 * 31. 下一个排列
 *
 * @date 2019/1/7
 */
public class _31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int L = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                L = i - 1;
                break;
            }
        }
        if (L == -1) {
            reverse(nums);
        } else {
            for (int i = nums.length - 1; i > 0; i--) {
                if(nums[i]>nums[L]){

                }
            }
        }
    }

    private void reverse(int[] nums) {
    }
}
