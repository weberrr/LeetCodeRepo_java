/**
 * 螺旋矩阵 II
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * @date 2018/10/24
 */
public class _59 {

    /**
     * 关键词：方向指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 设置方向指针way = 'R''D''L''U'
     **/

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int j = 0;
        matrix[i][j] = 1;
        String way = "R";
        int index = 1;
        while (matrix[i][j] != n * n) {
            switch (way) {
                case "D":
                    while (i < n) {
                        if (i == n - 1) {
                            break;
                        } else if (matrix[i + 1][j] == 0) {
                            matrix[++i][j] = ++index;
                        } else {
                            break;
                        }
                    }
                    way = "L";
                    break;
                case "R":
                    while (j < n) {
                        if (j == n - 1) {
                            break;
                        } else if (matrix[i][j + 1] == 0) {
                            matrix[i][++j] = ++index;
                        } else {
                            break;
                        }
                    }
                    way = "D";
                    break;
                case "U":
                    while (i > 0) {
                        if (matrix[i - 1][j] == 0) {
                            matrix[--i][j] = ++index;
                        } else {
                            break;
                        }
                    }
                    way = "R";
                    break;
                case "L":
                    while (j > 0) {
                        if (matrix[i][j - 1] == 0) {
                            matrix[i][--j] = ++index;
                        } else {
                            break;
                        }
                    }
                    way = "U";
                    break;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        _59 t = new _59();
        t.generateMatrix(3);
    }
}
