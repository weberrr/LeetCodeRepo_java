import java.util.Arrays;

/**
 * 只出现一次的数字 III(Single Number III)
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * @date 2018/11/24
 */
public class _260 {

    //时间复杂度O(n) 空间复杂度O(1)
    //利用异或计算的性质  a^b=b^a  0^a=a 得到两个数的异或
    //将所有数字分为两组，每组就得到唯一的两个数

    public int[] singleNumber(int[] nums) {

        int sum = 0;
        for (int num1 : nums) {
            sum ^= num1;
        }
        // flag 为最低为1的位
        int flag = sum & (~(sum - 1));
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & flag) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _260().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

}
