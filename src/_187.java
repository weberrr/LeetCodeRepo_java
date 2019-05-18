import java.util.*;

/**
 * 187. 重复的DNA序列
 *
 * @date 2019/5/18
 */
public class _187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        char[] map = new char[26];
        //map['A'-'A']=0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i < s.length() - 9; i++) {
            int temp = 0;
            for (int j = i; j < i + 10; j++) {
                char c = s.charAt(j);
                temp |= map[c - 'A'];
                temp <<= 2;
            }
            if (!words.add(temp) && doubleWords.add(temp)) {
                list.add(s.substring(i, i + 10));
            }
        }
        return list;
    }

}
