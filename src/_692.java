import java.util.*;

/**
 * Top K Frequent Words(前K个高频单词)
 *
 * @date 2018/11/15
 */
public class _692 {

    //哈希表 + 优先队列
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(
                (a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b)
        );
        for (String word: map.keySet()) {
            queue.add(word);
            if(queue.size()>k){
                queue.poll();
            }
        }
        LinkedList<String> res = new LinkedList<String>();
        while (!queue.isEmpty()){
            res.addFirst(queue.poll());
        }
        return res;
    }
}
