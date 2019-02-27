import java.util.Stack;

/**
 * 71. 简化路径
 *
 * @date 2019/2/27
 */
public class _71 {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/+");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!strings[i].equals(".") && !strings[i].equals("")) {
                stack.push(strings[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String s = "/b////c/d/";
        System.out.println(new _71().simplifyPath("/a//b////c/d//././/.."));
    }
}
