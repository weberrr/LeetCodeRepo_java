/**
 * 只出现一次的数字2 （Single Number 2）
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * @date 2018/11/24
 */
public class _137 {


    //时间复杂度O(32*n) 空间复杂度O(1)

    //int二进制只有32位，总共3N+1个数，计算每一位上的所有数字和是否%3 = 0；如果不是的话，则说明第3N+1个数字在该位上为1
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                int temp = num >> i & 1;
                sum += temp;
            }
            if (sum % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _137().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
