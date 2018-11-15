/**
 * Unique Path II（所有不同路径之二）
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * @date 2018/10/22
 */
public class _63 {
    //每次遍历一条左上到右下的斜线
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
