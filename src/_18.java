import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * @date 2019/1/3
 */
public class _18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int subTarget = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int twoSum = subTarget - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int dValue = twoSum - nums[left] - nums[right];
                    if (dValue < 0) {right--;}
                    else if (dValue > 0) {left++;}
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {left++;}
                        while (right > left && nums[right] == nums[right - 1]) {right--;}
                        left++;right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _18().fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }
}
