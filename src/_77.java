import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @date 2019/2/20
 */
public class _77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        dfs(n, k, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int startIndex, List<List<Integer>> res, List<Integer> list) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = startIndex; i < n; i++) {
            list.add(i + 1);
            dfs(n, k - 1, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _77().combine(4, 4));
    }
}
