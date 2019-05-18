/**
 * 169.求众数
 *
 * @date 2019/5/18
 */
public class _169 {
    public int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n >> (31 - i) & 1) == 1) {
                    bit[i]++;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if (bit[i] > nums.length / 2) {
                ret += (1 << (31 - i));
            }
        }
        return ret;
    }

}
