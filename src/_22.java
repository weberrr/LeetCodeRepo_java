import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 括号生成(Generate Parentheses)
 *
 * @date 2018/11/16
 */
public class _22 {

    /**
     * 关键词：回溯
     * 时间复杂度：o(2^n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：选择（Options） + 限制（Restraints） + 结束条件（Termination） ： ORT原则
     * 选择：( )
     * 限制：
     * 用left_num和right_num表示左右括号的可用数量。
     * 如果left_num < right_num,表明左括号用得多，可以加右括号也可以加左括号
     * 如果left_num = right_num,表明左右用的一样多，只可以加左括号
     * 结束：left_num和right_num都为0（用完括号）
     **/

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, n, n, "");
        return list;
    }


    public void backtrack(List<String> list, int leftNum, int rightNum, String subStr) {
        if (leftNum == 0 && rightNum == 0) {
            list.add(subStr);
        } else {
            if (leftNum <= rightNum && leftNum > 0) {
                backtrack(list, leftNum - 1, rightNum, subStr + "(");
            }
            if (rightNum > leftNum && rightNum > 0) {
                backtrack(list, leftNum, rightNum - 1, subStr + ")");
            }
        }
    }

    public static void main(String[] args) {
        _22 test = new _22();
        System.out.println(test.generateParenthesis(3));
    }
}
