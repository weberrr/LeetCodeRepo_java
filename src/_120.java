import java.util.List;

/**
 * 三角形最小路径和
 *
 * @date 2018/12/19
 */
public class _120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> subList = triangle.get(i);
            for (int j = 0; j < subList.size(); j++) {
                res.set(j, Math.min(res.get(j), res.get(j + 1)) + subList.get(j));
            }
        }
        return res.get(0);
    }
}
