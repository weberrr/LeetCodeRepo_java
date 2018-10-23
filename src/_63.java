/**
 * Unique Path II（所有不同路径之二）
 *
 * @author wangz
 * @date 2018/10/22
 */
public class _63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int b[][] = new int[m][n];
        b[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i <= n + m - 2; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > m - 1 || i - j > n - 1) {
                    continue;
                }
                if (obstacleGrid[j][i - j] == 0) {
                    if (j == 0) {
                        b[j][i - j] = b[j][i - j - 1];
                    } else if (j == i) {
                        b[j][i - j] = b[j - 1][i - j];
                    } else {
                        b[j][i - j] = b[j - 1][i - j] + b[j][i - j - 1];
                    }
                } else {
                    b[j][i - j] = 0;
                }
            }
        }
        return b[m - 1][n - 1];
    }

    public static void main(String[] args) {
        _63 test = new _63();
        int a[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(test.uniquePathsWithObstacles(a));
    }


}
