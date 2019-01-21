import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * @date 2019/1/17
 */
public class _68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int accumulate = 1;
        for (int i = 0; i < words.length; i++) {
            if (accumulate + words[i].length() <= maxWidth) {
                accumulate += words[i].length() + 1;
            }
        }
        return res;
    }
}
