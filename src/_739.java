import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * 每日温度
 *
 * @date 2018/12/18
 */
public class _739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (T[i] > T[index]) {
                    res[index] = i - index;
                    stack.pop();
                }else {
                    break;
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new _739().dailyTemperatures(t);
        for (int i = 0; i < t.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
