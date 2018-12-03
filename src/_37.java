import java.util.Arrays;
import java.util.HashSet;

/**
 * 解数独
 *
 * @date 2018/11/28
 */
public class _37 {

    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    public boolean dfs(char[][] board, int position) {
        if (position == 81) {
            return true;
        }
        int row = position / 9;
        int col = position % 9;
        if (board[row][col] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                board[row][col] = i;
                if (isValidSudoku(board)) {
                    if (dfs(board, position + 1)) {
                        return true;
                    }
                }
                board[row][col] = '.';
            }
        } else {
            return dfs(board, position + 1);
        }
        return false;
    }


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

    public static void main(String[] args) {
        char[][] t = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new _37().solveSudoku(t);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
    }
}
