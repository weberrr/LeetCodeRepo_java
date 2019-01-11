/**
 * 41. 缺失的第一个正数
 *
 * @date 2019/1/11
 */
public class _41 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new _41().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
