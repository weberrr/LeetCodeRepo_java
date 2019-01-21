import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @date 2019/1/15
 */
public class _54 {

    /**
     * 关键词：方向指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 借助方向指针和辅助标记位
     **/

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        char flag = 'R';
        int[][] help = new int[m][n];
        int i = 0, j = -1;
        while (res.size() < m * n) {
            switch (flag) {
                case 'R':
                    while ((j < n - 1 && help[i][j + 1] == 0)) {
                        help[i][++j] = 1;
                        res.add(matrix[i][j]);
                    }
                    flag = 'D';
                    break;
                case 'D':
                    while (i < m - 1 && help[i + 1][j] == 0) {
                        help[++i][j] = 1;
                        res.add(matrix[i][j]);
                    }
                    flag = 'L';
                    break;
                case 'L':
                    while (j > 0 && help[i][j - 1] == 0) {
                        help[i][--j] = 1;
                        res.add(matrix[i][j]);
                    }
                    flag = 'U';
                    break;
                case 'U':
                    while (i > 0 && help[i - 1][j] == 0) {
                        help[--i][j] = 1;
                        res.add(matrix[i][j]);
                    }
                    flag = 'R';
                    break;
            }
        }
        return res;
    }

    /**
     * 优化：[x1][y1] -> [x2][y2]
     * 关键词：坐标转移方程
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 找到每次循环一圈中，坐标转移方程，动态更新 x1，y1,x2,y2
     **/
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int x1 = 0, x2 = n - 1, y1 = 0, y2 = m - 1;
        while (x1 <= x2 && y1 <= y2) {
            for (int i = x1; i <= x2; i++) {
                res.add(matrix[y1][i]);
            }
            for (int i = y1 + 1; i <= y2; i++) {
                res.add(matrix[i][x2]);
            }
            if (x1 < x2 && y1 < y2) {
                for (int i = x2 - 1; i > x1; i--) {
                    res.add(matrix[y2][i]);
                }
                for (int i = y2; i > y1; i--) {
                    res.add(matrix[i][x1]);
                }
            }
            x1++;y1++;
            x2--;y2--;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new _54().spiralOrder2(new int[][]{{1, 2, 3},
                {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new _54().spiralOrder2(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
