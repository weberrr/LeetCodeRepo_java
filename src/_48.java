/**
 * 48. 旋转图像
 *
 * @date 2019/1/14
 */
public class _48 {

    /**
     * 关键词：异或交换 + 缩圈
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 每个数是从[x][y] -> [y][n-1-x],逆时针换 [n-1-y][x] <- [x][y]
     * 可以四个数一组,两两交换实现交换
     * 异或实现 a b 交换：a = a^b b = a^b a = a^b
     **/

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int row = n / 2 + n % 2;
        int col = n / 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x1 = i;
                int y1 = j;
                int x2 = n - 1 - y1;
                int y2 = x1;
                for (int k = 0; k < 3; k++) {
                    matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
                    matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
                    matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
                    x1 = x2;
                    y1 = y2;
                    x2 = n - 1 - y1;
                    y2 = x1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix2 = new int[][]{{1}};
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix0 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new _48().rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
