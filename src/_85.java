/**
 * 最大矩形
 *
 * @date 2018/12/11
 */

public class _85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] heights = new int[n];
            for (int j = 0; j < n; j++) {
                int t = i;
                while (t >= 0 && matrix[t][j] == '1') {
                    heights[j]++;
                    t--;
                }
            }
            res = Math.max(res, new _84().largestRectangleArea(heights));
        }
        return res;
    }
}
