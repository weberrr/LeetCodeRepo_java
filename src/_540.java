/**
 * 有序数组中的单一元素
 * @date 2018/12/3
 */
public class _540 {
    //位运算：异或
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
