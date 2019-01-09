import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @date 2019/1/2
 */
public class _15 {

    /**
     * 关键词：双指针
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(1)
     * <p>
     * 思路：排序 + 定和双指针
     * 先将数组排序，然后依次遍历，每次遍历的值记为a，则a + b + c = 0 的问题可以转换为 b + c = 0 - a（固定）的问题
     * b和c的求解可以通过双指针，如果 b + c < 0-a 则b下标++; 相反 则c下标--；
     * tip:注意数组中可能存在重复数字，则遇到相等的值时 需要跳过（如：a[i]==a[i-1]时，a[i]已经计算过）
     **/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
