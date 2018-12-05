/**
 * 二维区域和检索 - 矩阵不可变
 *
 * @date 2018/12/5
 */
public class _304 {

    //动态规划
    static class NumMatrix {
        public int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix != null && matrix.length != 0) {
                int m = matrix.length;
                int n = matrix[0].length;
                dp = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == 0 && j == 0) dp[i][j] = matrix[i][j];
                        else if (i == 0) dp[i][j] = dp[i][j - 1] + matrix[i][j];
                        else if (j == 0) dp[i][j] = dp[i - 1][j] + matrix[i][j];
                        else dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (dp == null || dp.length == 0) return 0;
            return dp[row2][col2] - (col1 - 1 >= 0 ? dp[row2][col1 - 1] : 0) - (row1 - 1 >= 0 ? dp[row1 - 1][col2] : 0) + ((row1 - 1 >= 0) && (col1 - 1 >= 0) ? dp[row1 - 1][col1 - 1] : 0);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-1}};
        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(0, 0, 0, 0);
        System.out.println(param_1);
    }
    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}
