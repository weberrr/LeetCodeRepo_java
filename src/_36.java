import java.util.HashSet;

/**
 * 有效的数独(Valid Sudoku)
 *
 * @date 2018/11/28
 */
public class _36 {

    /**
     * 关键词：哈希set
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(3n)
     * <p>
     * 思路：
     * 对每行每列每方建立set
     * 每方的遍历法：
     * rowIndex = 3 * (i / 3) + j / 3
     * colIndex = 3 * (i % 3) + j % 3
     **/

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                //第i个九宫格的第j个格点的表示
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}
