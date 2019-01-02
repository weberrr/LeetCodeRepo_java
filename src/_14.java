/**
 * 最长公共前缀
 *
 * @date 2019/1/2
 */
public class _14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = getCommonPrefix(res, strs[i]);
        }
        return res;
    }

    private String getCommonPrefix(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                res.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _14().longestCommonPrefix(new String[]{"ca", "a"}));
    }
}
