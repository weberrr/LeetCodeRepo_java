import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @date 2019/1/3
 */
public class _16 {

    /**
     * 关键词：双指针
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(1)
     * <p>
     * 思路：排序 + 最接近定和 双指针
     * 与15题类似，先将数组排序，然后依次遍历a[i]
     * 对每个a[i],可以使左指针为a[i+1],右指针为a[n]，然后计算三个值的和，并求得与target的绝对差值
     * tip:题目告诉答案唯一，所以不用跳过相同值
     **/

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
