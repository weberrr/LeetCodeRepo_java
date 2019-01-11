import java.util.Stack;

/**
 * 32. 最长有效括号
 *
 * @date 2019/1/8
 */
public class _32 {


    //动态规划
    //思路：https://segmentfault.com/a/1190000009141116
    public int longestValidParentheses(String s) {
        //dp[i]表示以s[i]结尾的最大长度
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);  // ()((()))
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }

    //使用栈
    public int longestValidParentheses2(String s) {
        //栈中存贮s的下标
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(i);
        }
        int maxLen = 0;
        int nextIndex = s.length();
        while (!stack.isEmpty()) {
            int curIndex = stack.pop();
            maxLen = Math.max(maxLen, nextIndex - curIndex - 1);
            nextIndex = curIndex;
        }
        return Math.max(nextIndex,maxLen);
    }


    public static void main(String[] args) {
        System.out.println(new _32().longestValidParentheses2("()()()"));
    }
}
