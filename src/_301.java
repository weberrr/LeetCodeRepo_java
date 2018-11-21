import java.util.ArrayList;
import java.util.List;

/**
 * 删除无效的括号(Remove Invalid Parentheses)
 *
 * @date 2018/11/21
 */
public class _301 {
    //DFS + 节支
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    public void dfs(String s, List<String> result, int checkIndex, int removeIndex, char[] pattern) {
        for (int stack = 0, i = checkIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pattern[0]) stack++;
            if (c == pattern[1]) stack--;
            if (stack >= 0) continue;
            for (int j = removeIndex; j <= i; j++) {
                //j == removeIndex 对应多个右括号重叠
                //s.charAt(j - 1) != pattern[1] 对应每次删除第一个右括号
                if (s.charAt(j) == pattern[1] && (j == removeIndex || s.charAt(j - 1) != pattern[1])) {
                    String temp  = s.substring(0, j) + s.substring(j + 1);
                    dfs(temp, result, i, j, pattern);
                }
            }
            //节支
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(pattern[0]=='('){
            dfs(reversed,result,0,0,new char[]{')','('});
        }else {
            result.add(reversed);
        }
    }

    public static void main(String[] args){
     _301 test = new _301();
        List<String> res = test.removeInvalidParentheses("()())");
        System.out.println(res);
    }

}
