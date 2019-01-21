import java.util.ArrayList;
import java.util.List;

/**
 * 52. N皇后 II
 *
 * @date 2019/1/15
 */
public class _52 {

    /**
     * 关键词：回溯
     * 时间复杂度：o(^n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * list存储每行中的列值，从而保证了行列不重合
     * check的时候只用check对角线
     **/

    private int ans = 0;

    public int totalNQueens(int n) {
        dfs(0, n, new ArrayList<>());
        return ans;
    }

    private void dfs(int index, int n, List<Integer> state) {
        if (index == n) {
            ans += 1;
        } else {
            for (int i = 0; i < n; i++) {
                if (checkBoard(state, index, i)) {
                    state.add(i);
                    dfs(index + 1, n, state);
                    state.remove(state.size() - 1);
                }
            }
        }
    }

    private boolean checkBoard(List<Integer> state, int x, int y) {
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) == y) return false;
            if (Math.abs(state.get(i) - y) == Math.abs(i - x)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _52().totalNQueens(5));
    }
}
