import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * @date 2019/1/17
 */
public class _68 {

    //法1：自己写的
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int count = 0;
        int sumWidth = 0;
        for (int i = 0; i < words.length; ) {
            if (sumWidth + words[i].length() + 1 <= maxWidth + 1) {
                sumWidth += words[i].length() + 1;
                count++;
                i++;
            } else {
                addStr(res, count, i, words, maxWidth, sumWidth, false);
                count = 0;
                sumWidth = 0;
            }
        }
        addStr(res, count, words.length, words, maxWidth, sumWidth, true);
        return res;
    }

    private void addStr(List<String> res, int count, int i, String[] words, int maxWidth, int sumWidth, boolean isLast) {
        StringBuilder temp = new StringBuilder();
        if (isLast) {
            for (int j = i - count; j < i - 1; j++) {
                temp.append(words[j]).append(" ");
            }
            temp.append(words[i - 1]);
            temp.append(generateSpace(maxWidth - sumWidth + 1));
        } else {
            if (count == 1) {
                temp.append(words[i - 1]);
                temp.append(generateSpace(maxWidth - words[i - 1].length()));
            } else {
                int blankWidth = maxWidth - sumWidth + count;
                for (int j = i - count; j <= i - 2; j++) {
                    int moreSpace = (blankWidth % (count - 1) > (j - i + count)) ? 1 : 0;
                    String spaceStr = generateSpace(blankWidth / (count - 1) + moreSpace);
                    temp.append(words[j]).append(spaceStr);
                }
                temp.append(words[i - 1]);
            }
        }
        res.add(temp.toString());
    }

    private String generateSpace(int count) {
        char[] chs = new char[count];
        for (int i = 0; i < count; i++) {
            chs[i] = ' ';
        }
        return new String(chs);
    }

    //法2：整体思路没变，但是结构进行了一定的优化
    public List<String> fullJustify2(String[] words, int maxWidth) {
        int start = 0, end = 0, rowLen;
        int wordsLen = words.length;
        StringBuilder sb;
        List<String> res = new ArrayList<>();
        while (start < wordsLen) {
            rowLen = 0;
            while (end < wordsLen && (end - start + rowLen + words[end].length()) <= maxWidth) {
                rowLen += words[end++].length();
            }
            end -= 1;
            sb = new StringBuilder();
            int board = 0, cnt = 0, number = 0;
            if (end - start > 0) {
                board = start + (maxWidth - rowLen) % (end - start) - 1; //计算空格数量不同的分界点
                number = (maxWidth - rowLen) / (end - start);
            }
            for (int i = start; i <= end; i++) {
                sb.append(words[i]);
                if (end < wordsLen) {  //不管最后一行
                    if (end - start > 0) {  //多个单词
                        cnt = i <= board ? number + 1 : number;
                    } else {
                        cnt = maxWidth - rowLen;
                    }
                } else {  //最后一行
                    cnt = i < end ? 1 : maxWidth - rowLen - (end - start);
                }
                sb.append(generateSpace(cnt));
            }
            end += 1;
            start = end;
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("This", "is", "an", "example", "of", "text", "justification.");
        List<String> res = new _68().fullJustify2((String[]) list.toArray(), 16);
        System.out.println(res);
    }
}
