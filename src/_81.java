/**
 * 81. 搜索旋转排序数组 II
 *
 * @date 2019/2/28
 */
public class _81 {

    //时间 o(n)
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[left]) { //左边为增
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {  //右边为增
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 1, 1};
        System.out.println(new _81().search(nums, 3));
    }
}
