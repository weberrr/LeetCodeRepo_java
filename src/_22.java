import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 括号生成(Generate Parentheses)
 *
 * @date 2018/11/16
 */
public class _22 {

    //回溯问题 ：具有限界条件的DFS算法称为回溯算法
    //选择（Options） + 限制（Restraints） + 结束条件（Termination）

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
