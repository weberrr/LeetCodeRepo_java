import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 *
 * @date 2018/12/17
 */
public class _51 {
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(n, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int n, int x, List<Integer> state) {
        if (x == n) {
            res.add(generateSolution(state));
            return;
        }
        for (int y = 0; y < n; y++) {
            if (checkBoard(x, y, state)) {
                state.add(y);
                dfs(n, x + 1, state);
                state.remove(state.size() - 1);
            }
        }
    }

    private boolean checkBoard(int x, int y, List<Integer> state) {
        for (int i = 0; i < state.size(); i++) {
            if (y == state.get(i)) return false;
            if (Math.abs(y - state.get(i)) == Math.abs(x - i)) return false;
        }
        return true;
    }

    private List<String> generateSolution(List<Integer> state) {
        List<String> solution = new ArrayList<>();
        for (Integer y : state) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < y; i++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int i = y + 1; i < state.size(); i++) {
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(new _51().solveNQueens(4));
    }

}
