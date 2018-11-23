/**
 * 生命游戏
 *
 * @date 2018/11/23
 */
public class _289 {

    //原地算法：二进制存储前后两次的细胞状态，如01表细胞死亡，通过一次位运算实现
    //11 细胞存活  10 细胞复活 右移一位
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && (surviveNum(board, i, j) == 2 || surviveNum(board, i, j) == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && surviveNum(board, i, j) == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int surviveNum(int[][] num, int i, int j) {
        int sum = 0;
        for (int p = Math.max(i - 1, 0); p <= Math.min(i + 1, num.length - 1); p++) {
            for (int k = Math.max(j - 1, 0); k <= Math.min(j + 1, num[0].length - 1); k++) {
                if (p == i && k == j) continue;
                    //01 11 都是满足的
                else if (num[p][k] % 2 == 1) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _289 test = new _289();
        int[][] t = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        test.gameOfLife(t);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(t[i][j]);
            }
        }
    }

}
