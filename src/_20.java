import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @date 2019/1/5
 */
public class _20 {

    /**
     * 关键词：哈希表 + 栈
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 将左括号放入栈中，每次遇到和栈顶匹配的右括号时弹栈
     **/


    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
