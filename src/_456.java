import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 132模式(132 Pattern)
 *
 * @date 2018/11/28
 */
public class _456 {

    //栈
    public boolean find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < second) return true;
            else while (!s.empty() && nums[i] > s.peek()) {
                second = s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,6,5,4,2,3,1};
        System.out.println(new _456().find132pattern(nums));
    }
}
