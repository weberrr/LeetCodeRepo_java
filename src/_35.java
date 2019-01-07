/**
 * 35. 搜索插入位置
 *
 * @date 2019/1/7
 */
public class _35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new _35().searchInsert(new int[]{1}, 0));
    }
}
