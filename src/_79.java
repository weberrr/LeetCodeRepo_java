/**
 * 79. 单词搜索
 *
 * @date 2019/2/28
 */
public class _79 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        } else if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        } else {
            char c = word.charAt(index);
            if (board[row][col] == c) {
                board[row][col] = '#';
                boolean res = dfs(board, word, index + 1, row + 1, col) ||
                        dfs(board, word, index + 1, row - 1, col) ||
                        dfs(board, word, index + 1, row, col + 1) ||
                        dfs(board, word, index + 1, row, col - 1);
                board[row][col] = c;
                return res;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        char[][] board2 = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word2 = "AAB";
        System.out.println(new _79().exist(board, word));
    }

}
