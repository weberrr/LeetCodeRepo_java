import java.util.*;

/**
 * word break 2 (单词拆分2)
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * 返回所有这些可能的句子。
 *
 * @date 2018/11/12
 */
public class _140 {
    //DFS 深度优先来解决
    //dfs(word[i:end],List<i>) = sum{word[i:j-1](in dict) + dfs(word[j:end],List<j>)}
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        return DFS(s, wordDict, map);
    }

    public List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        _140 test = new _140();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] wordDict = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"};
        List<String> wordDictList = Arrays.asList(wordDict);
        List<String> res = test.wordBreak(s, wordDictList);
        System.out.println(res);
    }
}
