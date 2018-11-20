import java.util.*;

/**
 * Concatenated Words （连接词）
 *
 * @date 2018/11/13
 */
public class _472 {


    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        List<String> wordDict = Arrays.asList(words);
        for (int i = 0; i < words.length; i++) {
            if (wordBreak(words[i], wordDict)) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        if (size == 0) {
            return false;
        }
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            if (wordDict.contains(s.substring(0, i + 1)) && i != size - 1) {
                dp[i] = 1;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j] == 1 && wordDict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = 1;
                        break;
                    }
                }
            }
        }
        return dp[size - 1] == 1;

    }


    public static void main(String[] args) {
        _472 test = new _472();
        String[] s = new String[]{"ccuu", "c", "u"};
        System.out.println(test.findAllConcatenatedWordsInADict(s));
    }

}
