import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 *
 * @date 2019/1/13
 */
public class _46 {

    /**
     * 关键词：回溯
     * 时间复杂度：o(^n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 每次交换一个值，index+1 进行回溯
     **/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> perAns = new ArrayList<>();
            for (int num : nums) {
                perAns.add(num);
            }
            list.add(perAns);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                backtrack(list, nums, index + 1);
                swap(nums, i, index);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new _46().permute(new int[]{1, 2, 3}));
    }
}
