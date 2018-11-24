/**
 * 只出现一次的数字(Single Number)
 *
 * @date 2018/11/24
 */
public class _136 {

    //利用异或计算的性质  a^b=b^a  0^a=a
    //时间复杂度O(n) 空间复杂度O(1)
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
