import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 *
 * @date 2018/12/18
 */
public class _93 {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, "");
        return res;
    }

    private void dfs(String s, int pos, int num, String path) {
        if (pos == s.length() && num == 4) {
            res.add(path.substring(0, path.length() - 1));
        }
        if (s.length() - pos > 3 * (4 - num)) {
            return;
        }
        //只含有1个字符
        if (pos < s.length()) {
            path += s.substring(pos, pos + 1) + '.';
            dfs(s, pos + 1, num + 1, path);
            path = path.substring(0, path.length() - 2);
        }
        //含有2个字符且首位不为零
        if (pos < s.length() - 1 && s.charAt(pos) != '0') {
            path += s.substring(pos, pos + 2) + '.';
            dfs(s, pos + 2, num + 1, path);
            path = path.substring(0, path.length() - 3);
        }
        //含有3个字符且首位不为零
        if (pos < s.length() - 2 && s.charAt(pos) != '0' && Integer.valueOf(s.substring(pos, pos + 3)) <= 255) {
            path += s.substring(pos, pos + 3) + '.';
            dfs(s, pos + 3, num + 1, path);
            path = path.substring(0, path.length() - 4);
        }

    }

    public static void main(String[] args) {
        System.out.println(new _93().restoreIpAddresses("25525511135"));
    }
}
