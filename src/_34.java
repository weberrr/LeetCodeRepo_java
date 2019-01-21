import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在排序数组中查找元素的第一个和最后一个位置(Find First and Last Position of Element in Sorted Array)
 *
 * @date 2018/11/27
 */
public class _34 {

    /**
     * 关键词：二分查找
     * 时间复杂度：o(log n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 传统的二分查找后，在找到nums[index]=target时，对其进行左右探索，来找到左右边界
     **/

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                while (mid >= left && nums[mid] == target) {
                    mid--;
                }
                res[0] = mid + 1;
                mid = (right + left) / 2;
                while (mid <= right && nums[mid] == target) {
                    mid++;
                }
                res[1] = mid - 1;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4};
        int target = 4;
        int[] res = new _34().searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
