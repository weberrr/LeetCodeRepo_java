import java.util.*;

/**
 * 单词的压缩编码(Short Encoding of Words)
 *
 * @date 2018/11/23
 */
public class _820 {
    //哈希表存储，删除每个词的后缀后求和
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        for (String word : set) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int sum = 0;
        for (String str : set) {
            sum += str.length() + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] t = {"time", "me", "bell"};
        _820 test = new _820();
        System.out.println(test.minimumLengthEncoding(t));
    }
}
