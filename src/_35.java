/**
 * 35. 搜索插入位置
 *
 * @date 2019/1/7
 */
public class _35 {

    /**
     * 关键词：二分查找
     * 时间复杂度：o(log n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 传统的二分查找
     * 修改边界left<right,如果相等则返回
     * 修改右边界更新为 right = mid 而非right = mid - 1，以保证right永远>=left
     **/

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
