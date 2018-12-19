import java.util.*;

/**
 * 数组嵌套
 *
 * @date 2018/12/19
 */
public class _565 {

    public int arrayNesting(int[] nums) {
        int[] state = new int[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int tempLength = 0;
            while (state[index] == 0) {
                state[index] = 1;
                index = nums[index];
                tempLength++;
            }
            maxLength = Math.max(maxLength, tempLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new _565().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }
}
