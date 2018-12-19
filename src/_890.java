import java.util.ArrayList;
import java.util.List;

/**
 * 查找和替换模式
 *
 * @date 2018/12/19
 */
public class _890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        pattern = pattern.toUpperCase();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            String temp = pattern;
            if (str.length() == pattern.length()) {
                for (int j = 0; j < pattern.length(); j++) {
                    temp = temp.replace(pattern.charAt(j), str.charAt(j));
                }
                for (int j = 0; j < str.length(); j++) {
                    str = str.replace(str.charAt(j), pattern.charAt(j));
                }
                if (temp.equals(words[i]) && str.equals(pattern)) {
                    list.add(temp);
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new _890().findAndReplacePattern(new String[]{"cba", "xyx", "yxx", "yyx"}, "abc"));
    }
}
