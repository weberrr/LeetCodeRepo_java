import java.util.ArrayList;
import java.util.Arrays;

/**
 * Maximum Swap(数组的度)
 *
 * @author wangz
 * @date 2018/10/23
 */
public class _697 {
    public int findShortestSubArray(int[] nums) {
        int[] a = new int[50000];   //记录num次数
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] += 1;
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {

                max = a[i] > max ? a[i] : max;

        }
        int b[] = new int[50000];   //记录相等最大值的数字i，只有前几个有数
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != max) {
                continue;
            } else {
                b[index] = i;
                index++;
            }
        }
        int c[] = new int[index];   //记录最大度的长度
        while (index > 0) {
            int first = 50001;
            int last = -1;
            --index;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == b[index]) {
                    first = first < i ? first : i;
                    last = last > i ? last : i;
                }
                ;

            }
            c[index] = last - first + 1;
        }
        Arrays.sort(c);
        return c[0];
    }

    public static void main(String[] args){
        _697 t = new _697();
        int[] s = {1,2,2,3,1,4,2};
        System.out.println(t.findShortestSubArray(s));
    }
}
