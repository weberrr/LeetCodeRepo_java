import java.util.Stack;

/**
 * 32. 最长有效括号
 *
 * @date 2019/1/8
 */
public class _32 {

    /**
     * 方法1
     * 关键词：动态规划/栈
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 用maxLen变量记录遍历时 每个dp[i] 比较下的最大值
     * 用dp[i]表示以s[i]结尾的最大长度，举个字符串例子：
     * ( ( ) ) ( ( ) ) (
     * 0 1 2 3 4 5 6 7 8
     * 状态转移方程：
     * 1. 当s[i]为'('时，dp[i]为0
     * 2. 当s[i]为')'时, 如果s[i-1]='('，dp[i] = dp[i-2] + 2
     * 3. 当s[i]为')'时, 考虑s[7],则需要和s[4]对应来得到括号，并加上dp[3]的长度。
     * 条件为：
     * s[i-dp[i-1]-1] = '(' 即 s[4] = '('
     * 方程为：
     * dp[i] = dp[i-dp[i-1]-2] + dp[i-1] + 2
     * dp[7  =      dp[3]      +  dp[6]  + 2
     **/


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

    /**
     * 方法2
     * 关键词：栈
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * ( ( ) ) ) ( ( ) ) (
     * 0 1 2 3 4 5 6 7 8 9
     * 可以观察到()想成对，一定是从一对相邻括号 () 开始的
     * 所以使用栈存储s[i]的下标 i
     * 当遇到栈顶为'('，s[i]为')'时，出栈，其余情况则入栈
     * 遍历完后，栈内存储的将是每个子串间的index值,如例子所示，则从栈顶往下存储的是： 9 4
     * 因为s可以分出两个不连续的子串: 0-3 5-8 , 所以记录 间隔的下标index，即可得出不连续子串的长度
     * 所以用maxLen记录栈中的值间的差 ： maxLen = max(maxLen,nextIndex - curIndex - 1)
     * 最后返回 max（maxLen,nextIndex），因为第一个首开头的子串无法记录下标
     **/
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
