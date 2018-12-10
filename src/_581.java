import java.util.Arrays;
import java.util.List;

/**
 * 最短无序连续子数组
 *
 * @date 2018/12/10
 */
public class _581 {

    // 建立一个排好序的数组，和未排序的数组比较 时间复杂度为o(nlogn)
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0, n);
        Arrays.sort(temp);
        int left = -1;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != temp[i]) {
                left = left == -1 ? i : left;
                right = i;
            }
        }
        return right == left ? 0 : right - left + 1;
    }

    // 原地算法，不申请额外的内存空间，时间复杂度为o(n)
    public int findUnsortedSubarray2(int[] nums) {
        int left = -1;
        int right = -2;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if (nums[i] < max) right = i;
            min = Math.min(nums[nums.length - 1 - i], min);
            if (nums[nums.length - 1 - i] > min) left = nums.length - 1 - i;
        }
        return right - left + 1;
    }


    public static void main(String[] args) {
        int[] temp = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(new _581().findUnsortedSubarray2(temp));
    }
}
