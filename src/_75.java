import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * @date 2019/2/25
 */
public class _75 {

    public void sortColors(int[] nums) {
        int i = 0, low = 0, high = nums.length - 1;
        while (i <= high) {
            if (nums[i] == 0) {
                switchNum(nums, i, low);
                i++;
                low++;
            } else if (nums[i] == 2) {
                switchNum(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private void switchNum(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2};
        new _75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
