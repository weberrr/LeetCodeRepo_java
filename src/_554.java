import java.util.*;

/**
 * 砖墙
 *
 * @date 2018/12/4
 */
public class _554 {

    //哈希表
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Integer value : map.values()) {
            max = value > max ? value : max;
        }
        return n - max;
    }

    public static void main(String[] args) {
    }
}
