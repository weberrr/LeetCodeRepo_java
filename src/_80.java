/**
 * 80. 删除排序数组中的重复项 II
 *
 * @date 2019/2/19
 */
public class _80 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        boolean flag = false;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                if (!flag) {
                    flag = true;
                    nums[++i] = nums[j];
                }
            } else {
                flag = false;
                nums[++i] = nums[j];
            }
        }
        return nums.length == 0 ? 0 : i + 1;
    }

    // 優化
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int res = new _80().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println(res);
    }
}
