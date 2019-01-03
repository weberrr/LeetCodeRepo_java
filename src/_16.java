import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @date 2019/1/3
 */
public class _16 {

    //双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minD = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int dValue = Math.abs(target - sum);
                if (dValue < minD) {
                    minD = dValue;
                    res = sum;
                }
                if (sum > target) right--;
                else left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _16().threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}
