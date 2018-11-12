import java.util.ArrayList;
import java.util.List;

/**
 * Word Break (单词拆分)
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * @date 2018/11/12
 */
public class _139 {

    //dp[i] = max(dp[j] ^ dict{s[j+1:i]})
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = 1;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] == 1 && wordDict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = 1;
                        break;
                    }
                }
            }
        }
        return dp[size - 1] == 1;
    }

    public static void main(String[] args){
        _139 test = new _139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(test.wordBreak("leetcode",list));
    }
}
