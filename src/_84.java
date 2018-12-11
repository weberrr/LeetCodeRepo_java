import java.util.Stack;

/**
 * 柱状图中最大的矩形
 *
 * @date 2018/12/11
 */
public class _84 {

    //利用栈，将矩阵变成一个升序高度求解问题
    //详解 https://www.cnblogs.com/ganganloveu/p/4148303.html

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(heights[i]);
                continue;
            }
            int top = stack.peek();
            if (heights[i] >= top) {
                stack.push(heights[i]);
            } else {
                int num = 1;
                while (!stack.isEmpty() && stack.peek() > heights[i]) {
                    top = stack.pop();
                    res = Math.max(res, top * (num++));
                }
                while (num > 0) {
                    stack.push(heights[i]);
                    num--;
                }
            }
        }
        int num = 1;
        while (!stack.isEmpty()) {
            int height = stack.pop();
            int perRectangleSize = height * (num++);
            res = Math.max(perRectangleSize, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{4, 2};
        System.out.println(new _84().largestRectangleArea(temp));
    }
}
